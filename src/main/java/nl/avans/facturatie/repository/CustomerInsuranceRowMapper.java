package nl.avans.facturatie.repository;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import nl.avans.facturatie.model.Customer;

/**
 * Created by Robin Schellius on 31-8-2016.
 */
class CustomerInsuranceRowMapper implements RowMapper<Customer>
{
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setInsurance(rs.getString("Insurance"));
        return customer;
    }
}
