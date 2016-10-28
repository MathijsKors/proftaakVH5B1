package nl.avans.facturatie.repository;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import nl.avans.facturatie.model.InsuranceCompany;

/**
 * Created by Robin Schellius on 31-8-2016.
 */
class InsuranceCompanyRowMapper implements RowMapper<InsuranceCompany>
{
    @Override
    public InsuranceCompany mapRow(ResultSet rs, int rowNum) throws SQLException {
        InsuranceCompany insuranceCompany = new InsuranceCompany();
        insuranceCompany.setId(rs.getInt("InsuranceCompanyID"));
        insuranceCompany.setName(rs.getString("Name"));
        insuranceCompany.setAddress(rs.getString("Address"));
        insuranceCompany.setCity(rs.getString("City"));
        insuranceCompany.setEmail(rs.getString("Email"));
        insuranceCompany.setTelnumber(rs.getString("TelNumber"));
        insuranceCompany.setZipCode(rs.getString("ZipCode"));
        return insuranceCompany;
    }
}
