/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;


import javax.validation.constraints.Size;

/**
 *
 * @author Dorian
 */
public class Appointment {
    
    @Size(min = 1, max = 32, message = "Te kort of te lang.")
    private String date;
    
    
    private String appointmentId;
    
    @Size(min = 1, max = 32, message = "Te kort of te lang.")
    private String fysiotherapistName;
    
    @Size(min = 1, max = 32, message = "Te kort of te lang.")
    private String status;
    
    @Size(min = 1, max = 32, message = "Te kort of te lang.")
    private String patientName;
    
    @Size(min = 1, max = 32, message = "Te kort of te lang.")
    private String treatmentCode;
    
    @Size(min = 1, max = 32, message = "Te kort of te lang.")
    private int treatmentTime;
    
    @Size(min = 1, max = 32, message = "Te kort of te lang.")
    private int patientId;
    
    @Size(min = 1, max = 32, message = "Te kort of te lang.")
    private String treatmentName;
    
    @Size(min = 1, max = 32, message = "Te kort of te lang.")
    private String treatmentPrice;
    
    /**
     *
     */
    public Appointment(){
    }
    
    /**
     *
     * @param date
     * @param appointmentId
     * @param fysiotherapistName
     * @param status
     * @param patientName
     * @param treatmentCode
     * @param treatmentTime
     * @param patientId
     * @param treatmentName
     * @param treatmentPrice
     */
    public Appointment(String date, String appointmentId, String fysiotherapistName, String status, String patientName, String treatmentCode, int treatmentTime, int patientId, String treatmentName, String treatmentPrice) {
        this.date = date;
        this.appointmentId = appointmentId;
        this.fysiotherapistName = fysiotherapistName;
        this.status = status;
        this.patientName = patientName;
        this.treatmentCode = treatmentCode;
        this.treatmentTime = treatmentTime;
        this.patientId = patientId;
        this.treatmentName = treatmentName;
        this.treatmentPrice = treatmentPrice;
    }

    /**
     *
     * @param fysiotherapistName
     */
    public void setFysiotherapistName(String fysiotherapistName) {
        this.fysiotherapistName = fysiotherapistName;
    }

    /**
     *
     * @param treatmentPrice
     */
    public void setTreatmentPrice(String treatmentPrice) {
        this.treatmentPrice = treatmentPrice;
    }

    /**
     *
     * @return
     */
    public String getTreatmentPrice() {
        return treatmentPrice;
    }

    /**
     *
     * @return
     */
    public String getDate() {
        return date;
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
    public String getFysiotherapistName() {
        return fysiotherapistName;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @return
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     *
     * @return
     */
    public String getTreatmentCode() {
        return treatmentCode;
    }

    /**
     *
     * @return
     */
    public int getTreatmentTime() {
        return treatmentTime;
    }

    /**
     *
     * @return
     */
    public int getPatientId() {
        return patientId;
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
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
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
     * @param fysiotherapistName
     */
    public void setPhysiotherapist(String fysiotherapistName) {
        this.fysiotherapistName = fysiotherapistName;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @param patientName
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     *
     * @param treatmentCode
     */
    public void setTreatmentCode(String treatmentCode) {
        this.treatmentCode = treatmentCode;
    }

    /**
     *
     * @param treatmentTime
     */
    public void setTreatmentTime(int treatmentTime) {
        this.treatmentTime = treatmentTime;
    }

    /**
     *
     * @param patientId
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     *
     * @param treatmentName
     */
    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

}
