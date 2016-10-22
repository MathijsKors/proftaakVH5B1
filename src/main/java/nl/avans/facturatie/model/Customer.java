/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author game
 */
public class Customer {
    
    private int customerID;

    @NotNull
    @Size(min = 1, max = 32)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 32)
    private String lastName;
    
    @NotNull
    @Size(min = 8, max = 9)
    private int BSN;
    
    @NotNull
    @Size(min = 1, max = 32)
    private String street;

    @NotNull
    @DecimalMin("1")
    private String houseNumber;

    @NotNull
    @Size(min = 1, max = 32)
    private String city;

    @NotNull
    @Size(min = 1, max = 32)
    private String phoneNumber;

    @NotNull
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="{invalid.email}")
    private String emailAddress;

    private java.util.Date lastUpdated;

    public Customer() {  }

    public Customer(String firstName, String lastName, int BSN,String street, String houseNumber, String city, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        // ID is de auto increment waarde uit de database.
        // wordt hier ingevuld wanneer een Customer aangemaakt wordt in de dtb.
        this.customerID = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() { return this.firstName + " " + this.lastName; }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public java.util.Date getLastUpdated() {
        return lastUpdated;
    }
    public int getBSN() {
        return BSN;
    }
    
    //Costumers vergelijken om de juiste te krijgen
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return getBSN() == customer.getBSN();
    }

}