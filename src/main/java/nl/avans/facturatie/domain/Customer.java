/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author game
 */
public class Customer {
    private String name, address, zipCode, city, phoneNumber, bankAccount;
    private Date birthDate;
    private int ID, CSN; //Citizen Service Number
    private boolean invoice, collection;
    List<Customer> customerList = new ArrayList<>();
            
    public Customer(int ID, String name, String address, String zipCode, String city, String phoneNumber, String bankAccount, Date birthDate, int CSN, boolean invoice, boolean collection) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.bankAccount = bankAccount;
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
    
    public List<Customer> getAllCustomers() {
        return customerList;
    }
    

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
