/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.domain;

import java.sql.Date;

/**
 *
 * @author Tom Maljaars
 */
public class Invoice extends Billing{

    public Invoice(String customerName, String address, String zipCode, String city, String treatment, Date invoiceDate, Date expirationDate, int prize, int ownRisk, int toBePaid) {
        super(customerName, address, zipCode, city, treatment, invoiceDate, expirationDate, prize, ownRisk, toBePaid);
    }
    
    public void printDigital(Billing billing) {
        
    }
    
    public void printPhysical(Billing billing) {
        
    }
    
    public void mailCustomer(Customer c) {
        
    }
}