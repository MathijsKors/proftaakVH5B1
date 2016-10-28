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
import java.util.ArrayList;
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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nl.avans.facturatie.model.Billing;
import nl.avans.facturatie.model.Customer;
import nl.avans.facturatie.service.CustomerService;

/**
 *
 * @author Tom Maljaars
 */
public class BillingRepository {
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Deze constructor wordt aangeroepen vanuit de config/PersistenceContext class.
    public BillingRepository(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource); }

    /**
     *
     * @return
     */
    @Transactional(readOnly=true)
    public List<Billing> findAll() {
        logger.info("findAll");
        List<Billing> result = jdbcTemplate.query("SELECT * FROM bills", new BillingRowMapper());
        logger.info("found " + result.size() + " bills");
        return result;
    }

    /**
     *
     * @param id
     * @return
     */
    @Transactional(readOnly=true)
    public Billing findBillingById(int id) {
        logger.info("findBillingById");
        return jdbcTemplate.queryForObject(
                "SELECT * FROM bills WHERE BillingID=?",
                new Object[]{id}, new BillingRowMapper());
    }

    /**
     *
     * @param billing
     * @return
     */
    public Billing create(final Billing billing) {

        logger.debug("create repository = " + billing.getBillingID());

        final String sql = "INSERT INTO bills(`CustomerName`, `Address`, `ZipCode`, `City`, `Treatment`, `InvoiceDate`, `Prize`, `OwnRisk`, `ToBePaid`, `BillingID`) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?)";

        // KeyHolder gaat de auto increment key uit de database bevatten.
        KeyHolder holder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, billing.getCustomerName());
                ps.setString(2, billing.getAddress());
                ps.setString(3, billing.getZipCode());
                ps.setString(4, billing.getCity());
                ps.setString(5, billing.getTreatment());
                ps.setDate(6, billing.getInvoiceDate());
                ps.setInt(7, billing.getPrize());
                ps.setInt(8, billing.getOwnRisk());
                ps.setInt(9, billing.getToBePaid());
                ps.setInt(10, billing.getBillingID());
                return ps;
            }
        }, holder);

        // Zet de auto increment waarde in de Customer
        int newBillingId = holder.getKey().intValue();
        billing.setBillingID(newBillingId);
        logger.info(sql);
        return billing;
    }

     public Billing edit(final Billing billing, int id) {

        logger.info("edit repository = " + billing.getBillingID());
        
        final String sql = "UPDATE `bills` SET `CustomerName` = ?, `Address` = ?, `ZipCode` = ?, `City` = ?, `Treatment` = ?, `InvoiceDate` = ?, `Prize` = ?, `OwnRisk` = ?, `ToBePaid` = ? WHERE `bills`.`BillingID` = ?;";
           
        
                //"UPDATE customers set (`FirstName`, `LastName`, `Street`, `HouseNumber`, `City`, `PhoneNumber`, `EmailAddress`, `bsnNumber`) WHERE CustomerID=?";

        // KeyHolder gaat de auto increment key uit de database bevatten.
        KeyHolder holder = new GeneratedKeyHolder();
        
        try {
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, billing.getCustomerName());
                ps.setString(2, billing.getAddress());
                ps.setString(3, billing.getZipCode());
                ps.setString(5, billing.getTreatment());
                ps.setDate(6, billing.getInvoiceDate());
                ps.setInt(8, billing.getOwnRisk());
                ps.setString(4, billing.getCity());
                ps.setInt(7, billing.getPrize());
                ps.setInt(9, billing.getToBePaid());
                ps.setInt(10, id);
                
                return ps;
            }
        }, holder);

        } catch (DataIntegrityViolationException e) {
            System.out.println(e);
        }
     
        
        
        
        return billing;
    }
    
    public void deleteBillingById(int id) {
        logger.debug("deleteBillingById");
        jdbcTemplate.update("DELETE FROM bills WHERE BillingID=?", new Object[]{id});
    }

    
        public boolean findBillingByBillingID(int billingID) {
        logger.debug("findBillingByBillingID");
        jdbcTemplate.update("SELECT FROM billing WHERE BillingID=?", new Object[]{billingID});
        return Boolean.TRUE;
    }

    
 
//    @Transactional(readOnly=true)
//    public boolean findBillingByBillingID(String billingID) {
//        logger.info("findBillingByBillingID");
//        Integer bilingID = jdbcTemplate.queryForObject("SELECT count(*) FROM bills WHERE billingID=918273953)", Integer.class, billingID);
//        
//        logger.info(billingID + "");
//        
//        if(billingID != null && billingID > 0){
//            return true;
//        }else{
//            return false;
//        }
//    }
}