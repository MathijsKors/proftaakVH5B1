    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

/**
 *
 * @author Tom Maljaars
 */
public class InsuranceCompany {
    
    public String name;
    public String address;
    public String zipCode;
    public String city;
    public String telNumber;
    public String email;

    public InsuranceCompany(String name, String address, String zipCode, String city, String telNumber, String email) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.telNumber = telNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getZipcode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipcode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    @Override
    public String toString() {
        return "InsuranceCompany{" + "name=" + name + ", address=" + address + ", zipCode=" + zipCode + ", city=" + city + ", telNumber=" + telNumber + ", email=" + email + '}';
    }
    
    
}
