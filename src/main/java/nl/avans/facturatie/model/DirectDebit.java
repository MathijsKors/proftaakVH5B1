/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Tom Maljaars
 */
public class DirectDebit{
    LocalDate now = LocalDate.now();                    //Current date variable
    LocalDate firstOfMonth = now.withDayOfMonth(1);     //First day of the month variable

    /**
     *
     * @param customerName
     * @param address
     * @param zipCode
     * @param city
     * @param treatment
     * @param invoiceDate
     * @param expirationDate
     * @param prize
     * @param ownRisk
     * @param toBePaid
     */
    public DirectDebit(String customerName, String address, String zipCode, String city, String treatment, Date invoiceDate, Date expirationDate, int prize, int ownRisk, int toBePaid) {
        //super(customerName, address, zipCode, city, treatment, invoiceDate, expirationDate, billingID, prize, ownRisk, toBePaid);
    }
    
    /**
     *
     */
    public void Debit() {
        //Check if current date is the first day of the month
        if (now == firstOfMonth) {
            //Deduct the monthly prize of the invoice
        }
    }
    
}
