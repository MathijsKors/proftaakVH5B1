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

    /**
     *
     */
    public Invoice() {  }
        
    /**
     *
     * @param invoiceID
     * @param duration
     * @param customerName
     * @param treatmentName
     * @param insuranceType
     * @param adress
     * @param price
     * @param totalPrice
     * @param deadline
     * @param invoiceDate
     * @param appointmentId
     */
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

    /**
     *
     * @param appointmentId
     */
    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     *
     * @return
     */
    public String getAppointmentId() {
        return appointmentId;
    }

    /**
     *
     * @return
     */
    public int getInvoiceID() {
        return invoiceID;
    }

    /**
     *
     * @return
     */
    public int getDuration() {
        return duration;
    }

    /**
     *
     * @return
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     *
     * @return
     */
    public String getTreatmentName() {
        return treatmentName;
    }

    /**
     *
     * @return
     */
    public String getInsuranceType() {
        return insuranceType;
    }

    /**
     *
     * @return
     */
    public String getAdress() {
        return adress;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     *
     * @return
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     *
     * @return
     */
    public Date getInvoiceDate() {
        return invoiceDate;
    }

    /**
     *
     * @param invoiceID
     */
    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    /**
     *
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     *
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     *
     * @param treatmentName
     */
    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    /**
     *
     * @param insuranceType
     */
    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    /**
     *
     * @param adress
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @param totalPrice
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     *
     * @param deadline
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    /**
     *
     * @param invoiceDate
     */
    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    
    
	
}