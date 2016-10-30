package nl.avans.facturatie.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nl.avans.facturatie.model.Appointment;

class AppointmentRowMapper implements RowMapper<Appointment>
{
    @Override
    public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(rs.getString("appointmentId"));
        appointment.setPhysiotherapist(rs.getString("physiotherapist"));
        appointment.setStatus(rs.getString("status"));
        appointment.setPatientName(rs.getString("patientName"));
        appointment.setTreatmentCode(rs.getString("treatmentCode"));
        appointment.setTreatmentTime(rs.getInt("treatmentTime"));
        appointment.setPatientId(rs.getInt("patientId"));
        appointment.setTreatmentName(rs.getString("treatmentName"));
        appointment.setDate(rs.getString("Date"));
        return appointment;
    }
}