package nl.avans.facturatie.repository;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import nl.avans.facturatie.model.Insurance;

/**
 * Created by Robin Schellius on 31-8-2016.
 */
class InsuranceRowMapper implements RowMapper<Insurance>
{
    @Override
    public Insurance mapRow(ResultSet rs, int rowNum) throws SQLException {
        Insurance insurance = new Insurance();
        insurance.setInsuranceID(rs.getInt("InsuranceID"));
        insurance.setType(rs.getString("Type"));
        insurance.setProfile(rs.getString("Profile"));
        insurance.setCostpMonth(rs.getString("CostpMonth"));

        return insurance;
    }
}
