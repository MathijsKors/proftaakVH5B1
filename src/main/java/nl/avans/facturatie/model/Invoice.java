/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import java.sql.Date;

/**
 *
 * @author Tom Maljaars
 */
public class Invoice {
	
    private int invoiceID, duration;
    private String customerName, treatmentName, insuranceType, adress, appointmentId;
    private double price, totalPrice;
    private Date deadline, invoiceDate;

    public Invoice() {  }
        
    public Invoice(int invoiceID, int duration, String customerName, String treatmentName, String insuranceType, String adress, double price, double totalPrice, Date deadline, Date invoiceDate, String appointmentId) {
        this.invoiceID = invoiceID;
        this.duration = duration;
        this.customerName = customerName;
        this.treatmentName = treatmentName;
        this.insuranceType = insuranceType;
        this.adress = adress;
        this.price = price;
        this.totalPrice = totalPrice;
        this.deadline = deadline;
        this.invoiceDate = invoiceDate;
        this.appointmentId = appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public int getDuration() {
        return duration;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public String getAdress() {
        return adress;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    
    
	
}