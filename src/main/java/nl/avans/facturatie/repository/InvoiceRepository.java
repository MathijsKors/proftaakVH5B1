/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import nl.avans.facturatie.model.Invoice;
import nl.avans.facturatie.service.CustomerService;

/**
 *
 * @author Tom Maljaars
 */
public class InvoiceRepository {
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Deze constructor wordt aangeroepen vanuit de config/PersistenceContext class.
    public InvoiceRepository(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource); }

    /**
     *
     * @return
     */
    @Transactional(readOnly=true)
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
    @Transactional(readOnly=true)
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
    public Invoice create(final Invoice invoice) {

        logger.debug("create repository = " + invoice.getInvoiceID());

        final String sql = "INSERT INTO invoices(`InvoiceID`, `Price`, `CustomerName`, `TreatmentName`, `Duration`, `Deadline`, `Adress`, `InvoiceDate`, `TotalPrice`, `InsuranceType`) " +
                "VALUES(?,?,?,?,?,?,?,?,?)";

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
                ps.setDate(6, invoice.getDeadline());
                ps.setString(7, invoice.getAdress());
                ps.setDate(8, invoice.getInvoiceDate());
                ps.setDouble(9, invoice.getTotalPrice());
                ps.setString(10, invoice.getInsuranceType());
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