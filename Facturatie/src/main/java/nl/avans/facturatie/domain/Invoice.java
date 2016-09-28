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
public class Invoice {
    private String customerName, address, zipCode, city, treatment;
    private Date invoiceDate, expirationDate;
    private int prize, ownRisk, toBePaid;
    
    public Invoice(){
        
    }
    
    
}
