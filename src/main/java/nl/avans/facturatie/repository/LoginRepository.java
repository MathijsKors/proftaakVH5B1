/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.BCrypt;
import org.springframework.jdbc.core.PreparedStatementCreator;

/**
 *
 * @author dyl
 */
@Repository
public class LoginRepository {
    private static final int HASHSIZE = 12;
    
    private final Logger logger = LoggerFactory.getLogger(LoginRepository.class);;
    
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Deze constructor wordt aangeroepen vanuit de config/PersistenceContext class.

    /**
     *
     * @param dataSource
     */
    public LoginRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource); 
    }
    
    /**
     *
     * @param username
     * @param password
     */
    public void saveAccount(String username, String password) {
        logger.info("saveAccount - login" + username + password);
        
        String hashedpassword = BCrypt.hashPassword(password, BCrypt.generateSalt(HASHSIZE));
        
        final String sql = "INSERT INTO users(`username`, `password`) " + "VALUES (?,?)";
        
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, username);
                ps.setString(2, hashedpassword);
                return ps;
            }    
        }
        );    
    }
    
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public boolean checkPassword(String username, String password) {
    List<String> account = this.jdbcTemplate.queryForList(
        "select password from users where username = ?", String.class, username); 
        if (account.isEmpty() || account.size() != 1) {
            return false;
        } else {
            String passwordFromDB = account.get(0);
                
            if (passwordFromDB == null ) {
                return false;
            }

            return BCrypt.checkPassword(password, passwordFromDB);

        }
    }
   
}