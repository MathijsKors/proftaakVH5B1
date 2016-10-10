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
public class Billing {
    private String customerName, address, zipCode, city, treatment;
    private Date invoiceDate, expirationDate;
    private int prize, ownRisk, toBePaid;
    
    public Billing(String customerName, String address, String zipCode, String city, String treatment, Date invoiceDate, Date expirationDate, int prize, int ownRisk, int toBePaid){
        this.customerName = customerName;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.treatment = treatment;
        this.invoiceDate = invoiceDate;
        this.expirationDate = expirationDate;
        this.prize = prize;
        this.ownRisk = ownRisk;
        this.toBePaid = toBePaid;
    }
    
    public int getPrize() {
        return prize;
    }
    
    public int getToBePaid() {
        return toBePaid;
    }
    
    public void lowerToBePaid(int amount) {
        toBePaid -= amount;
    }
    
    public void raiseToBePaid(int amount) {
        toBePaid += amount;
    } 
    
    
}
