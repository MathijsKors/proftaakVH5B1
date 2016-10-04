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
public class Invoice {
    private String customerName, address, zipCode, City, treatment;
    private Date invoiceDate, expirationDate;
    private int prize, ownRisk, toBePaid;
    
    public Invoice(String customerName, String address, String zipCode, String City, String treatment, Date invoiceDate, Date expirationDate, int prize, int ownRisk, int toBePaid) {
        this.customerName = customerName;
        this.address = address;
        this.zipCode = zipCode;
        this.City = City;
        this.treatment = treatment;
        this.invoiceDate = invoiceDate;
        this.expirationDate = expirationDate;
        this.prize = prize;
        this.ownRisk = ownRisk;
        this.toBePaid = toBePaid;
    }
    
}
