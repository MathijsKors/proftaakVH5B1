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

import nl.avans.facturatie.model.Appointment;
import nl.avans.facturatie.service.CustomerService;

/**
 *
 * @author Tom Maljaars
 */
public class AppointmentRepository {
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Deze constructor wordt aangeroepen vanuit de config/PersistenceContext class.
    public AppointmentRepository(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource); }

    /**
     *
     * @return
     */
    @Transactional(readOnly=true)
    public List<Appointment> findAll() {
        logger.info("findAll");
        List<Appointment> result = jdbcTemplate.query("SELECT * FROM appointments", new AppointmentRowMapper());
        logger.info("found " + result.size() + " appointments");
        return result;
    }

    /**
     *
     * @param id
     * @return
     */
    @Transactional(readOnly=true)
    public Appointment findAppointmentById(int id) {
        logger.info("findAppointmentById");
        return jdbcTemplate.queryForObject(
                "SELECT * FROM appointments WHERE AppointmentId = ?",
                new Object[]{id}, new AppointmentRowMapper());
    }

    /**
     *
     * @param appointment
     * @return
     */
    public Appointment create(final Appointment appointment) {

        

        final String sql = "INSERT INTO `appointments` (`physiotherapist`, `status`, `patientName`, `treatmentCode`, `treatmentTime`, `patientId`, `treatmentName`, `Date`) " +
                "VALUES(?,?,?,?,?,?,?,?,?)";

        // KeyHolder gaat de auto increment key uit de database bevatten.
        KeyHolder holder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(2, appointment.getFysiotherapistName());
                ps.setString(3, appointment.getStatus());
                ps.setString(4, appointment.getPatientName());
                ps.setString(5, appointment.getTreatmentCode());
                ps.setInt(6, appointment.getTreatmentTime());
                ps.setInt(7, appointment.getPatientId());
                ps.setString(8, appointment.getTreatmentName());
                ps.setString(9, appointment.getDate());
                
                return ps;
            }
        }, holder);

        // Zet de auto increment waarde in de Customer
        int newAppointmentId = holder.getKey().intValue();
        appointment.setAppointmentId(newAppointmentId + "");
        logger.info(sql);
        return appointment;
    }

     public Appointment edit(final Appointment appointment, int id) {

        logger.info("edit repository = " + appointment.getAppointmentId());
        
        final String sql = "UPDATE `appointments` SET `physiotherapist`, `status`, `patientName`, `treatmentCode`, `treatmentTime`, `patientId`, `treatmentName`, `Date` WHERE `AppointmentId` = ?;";
           
        // KeyHolder gaat de auto increment key uit de database bevatten.
        KeyHolder holder = new GeneratedKeyHolder();
        
        try {
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(2, appointment.getFysiotherapistName());
                ps.setString(3, appointment.getStatus());
                ps.setString(4, appointment.getPatientName());
                ps.setString(5, appointment.getTreatmentCode());
                ps.setInt(6, appointment.getTreatmentTime());
                ps.setInt(7, appointment.getPatientId());
                ps.setString(8, appointment.getTreatmentName());
                ps.setString(9, appointment.getDate());
                ps.setInt(10, id);
                return ps;
            }
        }, holder);

        } catch (DataIntegrityViolationException e) {
            System.out.println(e);
        }
     
        return appointment;
    }
    
    public void deleteAppointmentById(int id) {
        logger.debug("deleteAppointmentById");
        jdbcTemplate.update("DELETE FROM appointments WHERE AppointmentId=?", new Object[]{id});
    }

    
        public boolean findAppointmentByAppointmentID(int appointmentId) {
        logger.debug("findAppointmentByAppointmentId");
        jdbcTemplate.update("SELECT FROM appointment WHERE AppointmentId=?", new Object[]{appointmentId});
        return Boolean.TRUE;
    }
}