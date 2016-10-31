package nl.avans.facturatie.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nl.avans.facturatie.model.Invoice;

class InvoiceRowMapper implements RowMapper<Invoice>
{
    @Override
    public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setInvoiceID(rs.getInt("InvoiceID"));
        invoice.setPrice(rs.getDouble("Price"));
        invoice.setCustomerName(rs.getString("CustomerName"));
        invoice.setTreatmentName(rs.getString("TreatmentName"));
        invoice.setDuration(rs.getInt("Duration"));
        invoice.setDeadline(rs.getDate("Deadline"));
        invoice.setAdress(rs.getString("Adress"));
        invoice.setInvoiceDate(rs.getDate("InvoiceDate"));
        invoice.setTotalPrice(rs.getDouble("TotalPrice"));
        invoice.setInsuranceType(rs.getString("InsuranceType"));
        invoice.setInsuranceType(rs.getString("AppointmentId"));
        return invoice;
    }
}