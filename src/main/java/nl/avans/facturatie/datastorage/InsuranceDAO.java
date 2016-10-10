/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.datastorage;

import nl.avans.facturatie.domain.Insurance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dorian
 */
public class InsuranceDAO extends BaseDAO{
    
    public InsuranceDAO(DatabaseConnection con) {
        super(con);
    }
        public ArrayList<Insurance> FindInsurances(){
        ArrayList<Insurance> insurancelist = new ArrayList<>();

            ResultSet result;
            ResultSet info;

            // First open the database connection.
            DatabaseConnection connection = super.getDatabaseConnection();
            if(connection.openConnection())
            {
                try {
                    result = connection.executeSQLSelectStatement("SELECT * FROM `insurance`");
                    while(result.next()){
                        int insnumber = result.getInt("InsuranceNumber");
                        String insurancetype = result.getString("InsuranceType");
                        String insuranceprofile = result.getString("InsuranceProfile");
                        int costpMonth = result.getInt("costpMonth");
                        insurancelist.add(new Insurance(insnumber, insurancetype, insuranceprofile, costpMonth));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InsuranceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                connection.closeConnection();
            }

        return insurancelist;
    }     
}
