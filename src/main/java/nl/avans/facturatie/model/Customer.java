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
import nl.avans.facturatie.annotation.UniqueBSN;

/**
 *
 * @author game
 */
public class Customer {
    
    private int customerID;
    
    @NotNull
    @Size(min = 7, max = 10)
    //@UniqueBSN(message = "BSN is ongeldig")
    private String bsnNumber;

    @NotNull
    @Size(min = 1, max = 32)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 32)
    private String lastName;
    
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
            message="Email is incorrect")
    private String emailAddress;

    private java.util.Date lastUpdated;

    public Customer() {  }

    public Customer(String bsnNumber, String firstName, String lastName, String street, String houseNumber, String city, String phoneNumber, String emailAddress) {
        this.bsnNumber = bsnNumber;
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

    
    public String getBsnNumber() {
        return bsnNumber;
    }
    
    public void setBsnNumber(String bsnNumber) {
        this.bsnNumber = bsnNumber;
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
    
    private boolean isValidBSN(int candidate) {
        if (candidate <= 9999999 || candidate > 999999999) {
            return false;
        }
        int sum = -1 * candidate % 10;

        for (int multiplier = 2; candidate > 0; multiplier++) {
            int val = (candidate /= 10) % 10;
            sum += multiplier * val;
        }

        return sum != 0 && sum % 11 == 0;
    }


    
    //Costumers vergelijken om de juiste te krijgen
//    
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Customer)) return false;
//
//        Customer customer = (Customer) o;
//
//        return getBSNNumber() == customer.getBSNNumber();
//    }


}