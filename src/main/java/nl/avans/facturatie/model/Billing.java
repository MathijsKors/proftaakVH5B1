/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import java.sql.Date;

/**
 *
 * @author game
 */
public class Billing {
	private Date invoiceDate, expirationDate;
	private int billingID, duration, customerID, treatmentID;

        
        public Billing() {  }
        
	public Billing(int customerID, int treatmentID, Date invoiceDate, Date expirationDate, int billingID, int duration, int ownRisk, int toBePaid) {
		this.customerID = customerID;
		this.treatmentID = treatmentID;
		this.invoiceDate = invoiceDate;
		this.expirationDate = expirationDate;
		this.billingID = billingID;
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}

	public int getCustomerID() {
		return customerID;
	}

	public int getTreatmentID() {
		return treatmentID;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public int getBillingID() {
		return billingID;
	}


	public void setTreatmentID(int treatmentID) {
		this.treatmentID = treatmentID;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public void setBillingID(int billingID) {
		this.billingID = billingID;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
}