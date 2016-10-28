package nl.avans.facturatie.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Dorian
 */

public class Insurance {
    
    public int insuranceID;
    
    @NotNull
    @Size(min = 1, max = 35)
    public String type;
    
    @NotNull
    @Size(min = 1, max = 35)
    public String profile;
    
    @NotNull
    @DecimalMin("1")
    public String costpMonth;
   
    public Insurance() {  }
    
    public Insurance(String type, String profile, String costpMonth) {
        this.type = type;
        this.profile = profile;
        this.costpMonth = costpMonth;     
        // ID is de auto increment waarde uit de database.
        // wordt hier ingevuld wanneer een Insurance aangemaakt wordt in de dtb.
        this.insuranceID = 0;
    }

    public int getInsuranceID(){
        return insuranceID;
    }
    
    public String getType() {
        return type;
    }

    public String getProfile() {
        return profile;
    }

    public String getCostpMonth() {
        return costpMonth;
    }

    public void setInsuranceID(int insuranceID){
        this.insuranceID = insuranceID;
    }
     
    public void setType(String type) {
        this.type = type;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setCostpMonth(String costpMonth) {
        this.costpMonth = costpMonth;
    }      
}
