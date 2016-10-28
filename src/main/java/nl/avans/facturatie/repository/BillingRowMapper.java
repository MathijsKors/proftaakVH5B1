package nl.avans.facturatie.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nl.avans.facturatie.model.Billing;

class BillingRowMapper implements RowMapper<Billing>
{
    @Override
    public Billing mapRow(ResultSet rs, int rowNum) throws SQLException {
        Billing billing = new Billing();
        billing.setBillingID(rs.getInt("BillingID"));
        billing.setCustomerID(rs.getInt("CustomerID"));
        billing.setTreatmentID(rs.getInt("TreatmentID"));
        billing.setInvoiceDate(rs.getDate("InvoiceDate"));
        billing.setDuration(rs.getInt("Duration"));
        return billing;
    }
}