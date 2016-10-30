package nl.avans.facturatie.repository;

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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import nl.avans.facturatie.model.Customer;
import nl.avans.facturatie.service.CustomerService;
import nl.avans.facturatie.service.CustomerInsuranceService;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Created by Robin Schellius on 31-8-2016.
 */
@Repository
public class CustomerInsuranceRepository
{
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    // Deze constructor wordt aangeroepen vanuit de config/PersistenceContext class.

    /**
     *
     * @param dataSource
     */
    public CustomerInsuranceRepository(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource); }

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

    /**
     *
     * @param customer
     * @param id
     * @return
     */
    public Customer edit(final Customer customer, int id) {

        logger.info("edit repository = " + customer.getFullName());
        
        
        final String sql = "UPDATE `customers` SET `Insurance` = ? WHERE `customers`.`CustomerID` = ?;";

        // KeyHolder gaat de auto increment key uit de database bevatten.
        KeyHolder holder = new GeneratedKeyHolder();
        

        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, customer.getInsurance());
                ps.setInt(2, id);
                
                return ps;
            }
        }, holder);

        return customer;
    }
}