/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.domain;

import java.sql.Date;

/**
 *
 * @author game
 */
public class Customer {
    private String name, address, zipCode, city, phoneNumber;
    private Date birthDate;
    private int CSN; //Citizen Service Number
    private boolean invoice, collection;
            
    public Customer(String name, String address, String zipCode, String city, String phoneNumber, Date birthDate, int CSN, boolean invoice, boolean collection) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.CSN = CSN;
        this.invoice = invoice;
        this.collection = collection;
    }
    
    public void addCustomer() {
        
    }
    
    public void editCustomer() {
        
    }
    
    public void deleteCustomer() {
        
    }
    
}
