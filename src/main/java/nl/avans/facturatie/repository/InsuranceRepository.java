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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.List;
import nl.avans.facturatie.controller.InsuranceController;
import nl.avans.facturatie.model.Insurance;
import nl.avans.facturatie.service.InsuranceService;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Created by Robin Schellius on 31-8-2016.
 */
@Repository
public class InsuranceRepository
{
    private final Logger logger = LoggerFactory.getLogger(InsuranceService.class);;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Deze constructor wordt aangeroepen vanuit de config/PersistenceContext class.

    /**
     *
     * @param dataSource
     */
    public InsuranceRepository(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource); }

    /**
     *
     * @return
     */
    @Transactional(readOnly=true)
    public List<Insurance> findAll() {
        logger.info("findAll");
        List<Insurance> result = jdbcTemplate.query("SELECT * FROM insurances", new InsuranceRowMapper());
        logger.info("found " + result.size() + " insurances");
        return result;
    }

    /**
     *
     * @param id
     * @return
     */
    @Transactional(readOnly=true)
    public Insurance findInsuranceById(int id) {
        logger.info("findInsuranceById");
        return jdbcTemplate.queryForObject(
                "SELECT * FROM insurances WHERE InsuranceID=?",
                new Object[]{id}, new InsuranceRowMapper());
    }

    /**
     *
     * @param insurance
     * @return
     */
    public Insurance create(final Insurance insurance) {

        logger.debug("create repository = " + insurance.getType());

        final String sql = "INSERT INTO insurances(`Type`, `Profile`, `CostpMonth`) " +
                "VALUES(?,?,?)";

        // KeyHolder gaat de auto increment key uit de database bevatten.
        KeyHolder holder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, insurance.getType());
                ps.setString(2, insurance.getProfile());
                ps.setString(3, insurance.getCostpMonth());
                return ps;
            }
        }, holder);

        // Zet de auto increment waarde in de verzekering
        int newInsuranceId = holder.getKey().intValue();
        insurance.setInsuranceID(newInsuranceId);
        logger.info(sql);
        return insurance;
    }
    
     /**
     *
     * @param insurance
     * @param id
     * @return
     */

     public Insurance edit(final Insurance insurance, int id) {

        logger.info("edit repository = " + insurance.getType());
        
        final String sql = "UPDATE `insurances` SET `Type` = ?, `Profile` = ?, `CostpMonth` = ? WHERE `insurances`.`InsuranceID` = ?;";
           
        
                //"UPDATE insurances set (`Type`, `Profile`, `CostpMonth`) WHERE InsuranceID=?";

        // KeyHolder gaat de auto increment key uit de database bevatten.
        KeyHolder holder = new GeneratedKeyHolder();
        
        try {
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, insurance.getType());
                ps.setString(2, insurance.getProfile());
                ps.setString(3, insurance.getCostpMonth());
                ps.setInt(4, id);
                
                return ps;
            }
        }, holder);

        } catch (DataIntegrityViolationException e) {
            System.out.println(e);
        }
           
        return insurance;
     }
    
    /**
     *
     * @param id
     */
    public void deleteInsuranceById(int id) {
        logger.debug("deleteInsuranceById");
        jdbcTemplate.update("DELETE FROM insurances WHERE InsuranceID=?", new Object[]{id});
    }

    
        //public boolean findInsuranceByID(String bsn) {
        //logger.debug("findCustomerByBSN");
        //jdbcTemplate.update("SELECT FROM member WHERE bsnNumber=?", new Object[]{bsn});
        //return Boolean.TRUE;
    //}

    
 
//    @Transactional(readOnly=true)
//    public boolean findCustomerByBSN(String bsn) {
//        logger.info("findCustomerByBSN");
//        Integer dbbsn = jdbcTemplate.queryForObject("SELECT count(*) FROM customers WHERE bsnNumber=918273953)", Integer.class, bsn);
//        
//        logger.info(dbbsn + "");
//        
//        if(dbbsn != null && dbbsn > 0){
//            return true;
//        }else{
//            return false;
//        }
//    }
}