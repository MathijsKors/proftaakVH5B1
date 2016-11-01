package nl.avans.facturatie.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.List;
import javax.sql.DataSource;
import nl.avans.facturatie.model.InsuranceCompany;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gebruiker
 */
@Repository
public class InsuranceCompanyRepository {

    private final Logger logger = LoggerFactory.getLogger(InsuranceCompanyRepository.class);
    ;
    
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *
     * @param dataSource
     */
    public InsuranceCompanyRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<InsuranceCompany> findAll() {
        logger.info("findAll");
        List<InsuranceCompany> result = jdbcTemplate.query("SELECT * FROM insurancecompany", new InsuranceCompanyRowMapper());
        logger.info("found " + result.size() + " insurancecompanies");
        return result;
    }

    /**
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public InsuranceCompany findInsuranceCompanyById(int id) {
        logger.info("findInsuranceCompanyById");
        return jdbcTemplate.queryForObject(
                "SELECT * FROM insurancecompany WHERE InsuranceCompanyID=?",
                new Object[]{id}, new InsuranceCompanyRowMapper());
    }

    /**
     *
     * @param insuranceCompany
     * @return
     */
    public InsuranceCompany create(final InsuranceCompany insuranceCompany) {

        logger.debug("create repository = " + insuranceCompany.getName());

        final String sql = "INSERT INTO insurancecompany(`Name`, `Address`, `Zipcode`, `City`, `Telnumber`, `Email`) "
                + "VALUES(?,?,?,?,?,?)";

        // KeyHolder gaat de auto increment key uit de database bevatten.
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, insuranceCompany.getName());
                ps.setString(2, insuranceCompany.getAddress());
                ps.setString(4, insuranceCompany.getZipCode());
                ps.setString(3, insuranceCompany.getCity());
                ps.setString(5, insuranceCompany.getTelnumber());
                ps.setString(6, insuranceCompany.getEmail());
                return ps;
            }
        }, holder);

        // Zet de auto increment waarde in de Member
        int newInsuranceCompanyID = holder.getKey().intValue();
        insuranceCompany.setId(newInsuranceCompanyID);
        return insuranceCompany;
    }

    /**
     *
     * @param id
     */
    public void deleteInsuranceCompanyById(int id) {
        logger.debug("deleteInsuranceCompanyById");
        jdbcTemplate.update("DELETE FROM insurancecompany WHERE InsuranceCompanyID=?", new Object[]{id});
    }

}
