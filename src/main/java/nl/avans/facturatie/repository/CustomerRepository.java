package nl.avans.facturatie.repository;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.List;
import nl.avans.facturatie.controller.CustomerController;
import nl.avans.facturatie.model.Customer;
import nl.avans.facturatie.service.CustomerService;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Created by Robin Schellius on 31-8-2016.
 */
@Repository
public class CustomerRepository
{
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Deze constructor wordt aangeroepen vanuit de config/PersistenceContext class.
    public CustomerRepository(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource); }

    /**
     *
     * @return
     */
    @Transactional(readOnly=true)
    public List<Customer> findAll() {
        logger.info("findAll");
        List<Customer> result = jdbcTemplate.query("SELECT * FROM customers", new CustomerRowMapper());
        logger.info("found " + result.size() + " customers");
        return result;
    }

    /**
     *
     * @param id
     * @return
     */
    @Transactional(readOnly=true)
    public Customer findCustomerById(int id) {
        logger.info("findCustomerById");
        return jdbcTemplate.queryForObject(
                "SELECT * FROM customers WHERE CustomerID=?",
                new Object[]{id}, new CustomerRowMapper());
    }
    
    
    //bsn nummer controleren
    public int findcustomerByBSN(String bsn){
        String sql = "SELECT COUNT(*) FROM customers WHERE bsnNumber=?";
        return jdbcTemplate.queryForObject(sql, new Object[] { bsn }, int.class);
    }
    
     

    /**
     *
     * @param customer
     * @return
     */
    public Customer create(final Customer customer) {

        logger.debug("create repository = " + customer.getFullName());

        final String sql = "INSERT INTO customers(`FirstName`, `LastName`, `Street`, `HouseNumber`, `City`, `PhoneNumber`, `EmailAddress`, `bsnNumber`) " +
                "VALUES(?,?,?,?,?,?,?,?)";

        // KeyHolder gaat de auto increment key uit de database bevatten.
        KeyHolder holder = new GeneratedKeyHolder();
        
//        try{
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, customer.getFirstName());
                ps.setString(2, customer.getLastName());
                ps.setString(4, customer.getHouseNumber());
                ps.setString(3, customer.getStreet());
                ps.setString(5, customer.getCity());
                ps.setString(6, customer.getPhoneNumber());
                ps.setString(7, customer.getEmailAddress());
                ps.setString(8, customer.getBsnNumber());
                return ps;
            }
        }, holder);
        
        int newCustomerId = holder.getKey().intValue();
        customer.setCustomerID(newCustomerId);
        logger.info(sql);
        return customer;
    }

     public Customer edit(final Customer customer, int id) {

        logger.info("edit repository = " + customer.getFullName());
        
        final String sql = "UPDATE `customers` SET `FirstName` = ?, `LastName` = ?, `Street` = ?, `HouseNumber` = ?, `City` = ?, `PhoneNumber` = ?, `EmailAddress` = ?, `bsnNumber` = ? WHERE `customers`.`CustomerID` = ?;";
           
        
                //"UPDATE customers set (`FirstName`, `LastName`, `Street`, `HouseNumber`, `City`, `PhoneNumber`, `EmailAddress`, `bsnNumber`) WHERE CustomerID=?";

        // KeyHolder gaat de auto increment key uit de database bevatten.
        KeyHolder holder = new GeneratedKeyHolder();
        
        try {
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, customer.getFirstName());
                ps.setString(2, customer.getLastName());
                ps.setString(4, customer.getHouseNumber());
                ps.setString(3, customer.getStreet());
                ps.setString(5, customer.getCity());
                ps.setString(6, customer.getPhoneNumber());
                ps.setString(7, customer.getEmailAddress());
                ps.setString(8, customer.getBsnNumber());
                ps.setInt(9, id);
                
                return ps;
            }
        }, holder);

        } catch (DataIntegrityViolationException e) {
            System.out.println(e);
        }
     
        return customer;
    }

    
    public void deleteCustomerById(int id) {
        logger.debug("deleteCustomerById");
        jdbcTemplate.update("DELETE FROM customers WHERE CustomerID=?", new Object[]{id});
    }
}