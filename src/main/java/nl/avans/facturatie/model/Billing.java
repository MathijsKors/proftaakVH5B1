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
	private String customerName, address, zipCode, city, treatment;
	private Date invoiceDate, expirationDate;
	private int billingID, prize, ownRisk, toBePaid;

	public Billing() {}	
	
	public Billing(String customerName, String address, String zipCode, String city, String treatment, Date invoiceDate,
			Date expirationDate, int billingID, int prize, int ownRisk, int toBePaid) {
		this.customerName = customerName;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.treatment = treatment;
		this.invoiceDate = invoiceDate;
		this.expirationDate = expirationDate;
		this.billingID = 0;
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

	public String getCustomerName() {
		return customerName;
	}

	public String getAddress() {
		return address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getTreatment() {
		return treatment;
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

	public int getOwnRisk() {
		return ownRisk;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public void setBillingID(int billingID) {
		this.billingID = billingID;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public void setToBePaid(int toBePaid) {
		this.toBePaid = toBePaid;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setOwnRisk(int ownRisk) {
		this.ownRisk = ownRisk;
	}

	
}