package nl.avans.facturatie.datastorage;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import nl.avans.facturatie.domain.Customer;

/**
 * Created by Robin Schellius on 31-8-2016.
 */
class CustomerRowMapper implements RowMapper<Customer>
{
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerID(rs.getInt("CustomerID"));
        customer.setFirstName(rs.getString("FirstName"));
        customer.setLastName(rs.getString("LastName"));
        customer.setStreet(rs.getString("Street"));
        customer.setHouseNumber(rs.getString("HouseNumber"));
        customer.setCity(rs.getString("City"));
        customer.setPhoneNumber(rs.getString("PhoneNumber"));
        customer.setEmailAddress(rs.getString("EmailAddress"));
        customer.setFine(rs.getDouble("Fine"));
        return customer;
    }
}
