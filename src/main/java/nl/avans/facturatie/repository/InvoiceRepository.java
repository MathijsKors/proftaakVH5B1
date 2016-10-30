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
     * @return
     */
    public Invoice create(Invoice invoice, Customer customer) {

           
        // Calendar vraagt huidige datum op, dit wordt omgezet naar sql formaat date 
        //
        java.sql.Date invoiceDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        //
        // Calendar vraagt huidige datum op en voegt hier 1 maan aan toe, zet het daarna om naar sql formaat date
        //
        Calendar deadlineCalendar = Calendar.getInstance();
        deadlineCalendar.add(Calendar.MONTH, 1);
        java.sql.Date deadlineDate = new java.sql.Date(deadlineCalendar.getInstance().getTime().getTime());

        final String sql = "INSERT INTO invoices(`Price`, `CustomerName`, `TreatmentName`, `Duration`, `Deadline`, `Adress`, `InvoiceDate`, `TotalPrice`, `InsuranceType`, `appointmentId`) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";

        // KeyHolder gaat de auto increment key uit de database bevatten.
        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setDouble(1, invoice.getPrice());
                ps.setString(2, invoice.getCustomerName());
                ps.setString(3, invoice.getTreatmentName());
                ps.setInt(4, invoice.getDuration());
                ps.setDate(5, deadlineDate);
                ps.setString(6, invoice.getAdress());
                ps.setDate(7, invoiceDate);
                ps.setDouble(8, (invoice.getPrice() + invoice.getDuration()) );
                ps.setString(9, customer.getInsurance());
                ps.setString(10, invoice.getAppointmentId());
                return ps;
            }
        }, holder);

        // Zet de auto increment waarde in de Customer
        int newInvoiceId = holder.getKey().intValue();
        invoice.setInvoiceID(newInvoiceId);
        logger.info(sql);
        return invoice;
    }

    public void deleteInvoiceById(int id) {
        logger.debug("deleteInvoiceById");
        jdbcTemplate.update("DELETE FROM invoices WHERE InvoiceID=?", new Object[]{id});
    }

}
