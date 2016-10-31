/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;
import nl.avans.facturatie.model.Appointment;
import nl.avans.facturatie.model.Billing;
import nl.avans.facturatie.model.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import nl.avans.facturatie.model.Invoice;
import nl.avans.facturatie.model.Treatment;
import nl.avans.facturatie.service.AppointmentService;
import nl.avans.facturatie.service.CustomerService;

/**
 *
 * @author Tom Maljaars
 */
public class InvoiceRepository {

    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    ;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Deze constructor wordt aangeroepen vanuit de config/PersistenceContext class.
    public InvoiceRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<Invoice> findAll() {
        logger.info("findAll");
        List<Invoice> result = jdbcTemplate.query("SELECT * FROM invoices", new InvoiceRowMapper());
        logger.info("found " + result.size() + " invoices");
        return result;
    }

    /**
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Invoice findInvoiceById(int id) {
        logger.info("findInvoiceById");
        return jdbcTemplate.queryForObject(
                "SELECT * FROM invoices WHERE InvoiceID = ?",
                new Object[]{id}, new InvoiceRowMapper());
    }

    /**
     *
     * @param invoice
     * @param customer
     * @return
     */
    public Invoice create(Invoice invoice, Customer customer) {

        
        
        // Calendar vraagt huidige datum op, dit wordt omgezet naar sql formaat date 
        java.sql.Date invoiceDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
  
        // Calendar vraagt huidige datum op en voegt hier 1 maan aan toe, zet het daarna om naar sql formaat date
        Calendar deadlineCalendar = Calendar.getInstance();
        deadlineCalendar.add(Calendar.MONTH, 1);
        java.sql.Date deadlineDate = new java.sql.Date(deadlineCalendar.getInstance().getTime().getTime());

        final String sql = "INSERT INTO invoices(`InvoiceID`, `Price`, `CustomerName`, `TreatmentName`, `Duration`, `Deadline`, `Adress`, `InvoiceDate`, `TotalPrice`, `InsuranceType`, `appointmentId`) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        // KeyHolder gaat de auto increment key uit de database bevatten.
        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, invoice.getInvoiceID());
                ps.setDouble(2, invoice.getPrice());
                ps.setString(3, invoice.getCustomerName());
                ps.setString(4, invoice.getTreatmentName());
                ps.setInt(5, invoice.getDuration());
                ps.setDate(6, deadlineDate);
                ps.setString(7, invoice.getAdress());
                ps.setDate(8, invoiceDate);
                ps.setDouble(9, (invoice.getPrice() + invoice.getDuration()) );
                ps.setString(10, customer.getInsurance());
                ps.setString(11, invoice.getAppointmentId());
                return ps;
            }
        }, holder);

        // Zet de auto increment waarde in de Customer
        int newInvoiceId = holder.getKey().intValue();
        invoice.setInvoiceID(newInvoiceId);
        logger.info(sql);
        
        
        
        return invoice;
    }

    /**
     *
     * @param invoice
     * @param customer
     * @return
     */
    public Boolean accept(Appointment appointment, Customer customer) {

        //Invoice invoice = new Invoice();
        
        Boolean newinvoice = false;
        
        //Variabelen aanmaken
//        logger.info(appointment.getTreatmentPrice());
//        String priceString = appointment.getTreatmentPrice().replace(",",".");
//        logger.info(priceString);
        double price = Double.parseDouble(appointment.getTreatmentPrice().replace(",","."));
//        logger.info(price+"");
        
        
        // Calendar vraagt huidige datum op, dit wordt omgezet naar sql formaat date 
        java.sql.Date invoiceDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
  
        // Calendar vraagt huidige datum op en voegt hier 1 maan aan toe, zet het daarna om naar sql formaat date
        Calendar deadlineCalendar = Calendar.getInstance();
        deadlineCalendar.add(Calendar.MONTH, 1);
        java.sql.Date deadlineDate = new java.sql.Date(deadlineCalendar.getInstance().getTime().getTime());

        final String sql = "INSERT INTO invoices(`InvoiceID`, `Price`, `CustomerName`, `TreatmentName`, `Duration`, `Deadline`, `Adress`, `InvoiceDate`, `TotalPrice`, `InsuranceType`, `appointmentId`) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        // KeyHolder gaat de auto increment key uit de database bevatten.
        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, Integer.parseInt(appointment.getAppointmentId()));
                ps.setDouble(2,  price);
                ps.setString(3, customer.getFullName());
                ps.setString(4, appointment.getTreatmentName());
                ps.setInt(5, appointment.getTreatmentTime());
                ps.setDate(6, deadlineDate);
                ps.setString(7, (customer.getStreet() + " " + customer.getHouseNumber() + " " + customer.getCity()));
                ps.setDate(8, invoiceDate);
                ps.setDouble(9, (80.0 * appointment.getTreatmentTime() ));
                ps.setString(10, customer.getInsurance());
                ps.setString(11, appointment.getAppointmentId());
                return ps;
            }
        }, holder);

        // Zet de auto increment waarde in de Customer
//        int newInvoiceId = holder.getKey().intValue();
//        invoice.setInvoiceID(newInvoiceId);
        logger.info(sql);
        
        newinvoice = true;
        
        return newinvoice;
    }

    public void deleteInvoiceById(int id) {
        logger.debug("deleteInvoiceById");
        jdbcTemplate.update("DELETE FROM invoices WHERE InvoiceID=?", new Object[]{id});
    }

   
}
