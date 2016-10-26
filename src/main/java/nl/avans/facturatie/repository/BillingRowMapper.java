package nl.avans.facturatie.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nl.avans.facturatie.model.Billing;
import nl.avans.facturatie.model.Customer;

class BillingRowMapper implements RowMapper<Billing>
{
    @Override
    public Billing mapRow(ResultSet rs, int rowNum) throws SQLException {
        Billing billing = new Billing();
        billing.setBillingID(rs.getInt("BillingID"));
        billing.setCustomerName(rs.getString("CustomerName"));
        billing.setAddress(rs.getString("Address"));
        billing.setZipCode(rs.getString("ZipCode"));
        billing.setCity(rs.getString("City"));
        billing.setTreatment(rs.getString("Treatment"));
        billing.setInvoiceDate(rs.getDate("InvoiceDate"));
        billing.setPrize(rs.getInt("Prize"));
        billing.setOwnRisk(rs.getInt("OwnRisk"));
        billing.setToBePaid(rs.getInt("ToBePaid"));
        return billing;
    }
}