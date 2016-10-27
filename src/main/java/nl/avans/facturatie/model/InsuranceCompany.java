    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Tom Maljaars
 */
public class InsuranceCompany {
    
    @NotNull
    @Size(min = 1, max = 35)
    public String Name;
    @NotNull
    @Size(min = 1, max = 35)
    public String Address;
    @NotNull
    @Size(min = 1, max = 35)
    public String Zipcode;
    @NotNull
    @Size(min = 1, max = 35)
    public String City;
    @NotNull
    @Size(min = 1, max = 35)
    public String Telnumber;@NotNull
    @Size(min = 1, max = 35)
    public String Email;
    public int InsuranceCompanyID;

    public InsuranceCompany() {  }

    public InsuranceCompany(String Name, String Address, String Zipcode, String City, String Telnumber, String Email, int InsuranceCompanyID) {
        this.Name = Name;
        this.Address = Address;
        this.Zipcode = Zipcode;
        this.City = City;
        this.Telnumber = Telnumber;
        this.Email = Email;
        this.InsuranceCompanyID = 0;
    }
    

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getZipCode() {
        return Zipcode;
    }

    public String getCity() {
        return City;
    }

    public String getTelnumber() {
        return Telnumber;
    }

    public String getEmail() {
        return Email;
    }

    public int getId() {
        return InsuranceCompanyID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setZipCode(String Zipcode) {
        this.Zipcode = Zipcode;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setTelnumber(String Telnumber) {
        this.Telnumber = Telnumber;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setId(int InsuranceCompanyID) {
        this.InsuranceCompanyID = InsuranceCompanyID;
    }

    

    @Override
    public String toString() {
        return "InsuranceCompany{" + "name=" + Name + ", address=" + Address + ", Zipcode=" + Zipcode + ", city=" + City + ", telNumber=" + Telnumber + ", email=" + Email + '}';
    }
    
    
}
