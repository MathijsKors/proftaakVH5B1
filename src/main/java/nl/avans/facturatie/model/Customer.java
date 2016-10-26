/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import java.sql.Date;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import nl.avans.facturatie.annotation.UniqueBSN; //import is voor de UniqueBSN



/**
 *
 * @author game
 */
public class Customer {
    
    private int customerID;
    
    @NotNull
    @Size(min = 9, max = 10, message = "BSN moet 9 tot 10 cijfers bevatten.")
    //@UniqueBSN(message = "BSN is al in gebruik!")
    private String bsnNumber;

    @NotNull
    @Size(min = 1, max = 32, message = "Naam is te kort of te lang.")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 32, message = "Achternaam is te kort of te lang.")
    private String lastName;
    
    @NotNull
    @Size(min = 1, max = 32, message = "Straatnaam is te kort of te lang.")
    private String street;

    @NotNull
    @DecimalMin(value = "1", message = "Huisnummer mag alleen 1 of meerdere cijfers zijn.")
    private String houseNumber;

    @NotNull
    @Size(min = 1, max = 32, message = "Stad is te kort of te lang.")
    private String city;

    @NotNull
    @Size(min = 1, max = 32, message = "Telefoonummer is te kort of te lang.")
    //@Pattern(regexp = "/\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})/", message = "Telefoon nummer is in een niet goed formaat")
    private String phoneNumber;
    
    @NotNull 
    @Size(min = 1, max = 32, message = "Geboortedatum is te kort of te lang.")
    private java.util.Date birthDate;
    
    @NotNull
    @Size(min = 1, max = 32, message = "Emailadres is te kort of te lang.")
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="Emailadres niet juist formaat")
    private String emailAddress;

    private java.util.Date lastUpdated;
    

    /**
     *
     */
    public Customer() {  }

    /**
     *
     * @param bsnNumber
     * @param firstName
     * @param lastName
     * @param BirthDate
     * @param street
     * @param houseNumber
     * @param city
     * @param phoneNumber
     * @param emailAddress
     */
    public Customer(String bsnNumber, String firstName, String lastName, String BirthDate, String street, String houseNumber, String city, String phoneNumber, String emailAddress) {
        this.bsnNumber = bsnNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        
        // ID is de auto increment waarde uit de database.
        // wordt hier ingevuld wanneer een Customer aangemaakt wordt in de dtb.
        this.customerID = 0;
    }

    /**
     *
     * @return
     */
    public String getBsnNumber() {
        return bsnNumber;
    }
    
    /**
     *
     * @param bsnNumber
     */
    public void setBsnNumber(String bsnNumber) {
        this.bsnNumber = bsnNumber;
    }
    
    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     *
     * @return BirthDate
     */
    public java.util.Date getBirthDate() {
        return birthDate;
    }

    /**
     *
     * @param BirthDate
     */
    public void setBirthDate(java.util.Date BirthDate) {
        this.birthDate = birthDate;
    }

    /**
     *
     * @return
     */
    public String getFullName() { return this.firstName + " " + this.lastName; }

    /**
     *
     * @return
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @return
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     *
     * @param houseNumber
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     *
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     *
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     *
     * @return
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     *
     * @return
     */
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


    
    //Costumers vergelijken om de juiste te krijgen kan worden gebruikt voor UniqueBSN
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return getBsnNumber()== customer.getBsnNumber();
    }


}