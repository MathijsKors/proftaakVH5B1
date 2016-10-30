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
    
    

    
    public Appointment(){
    }
    
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

    public void setFysiotherapistName(String fysiotherapistName) {
        this.fysiotherapistName = fysiotherapistName;
    }

    public void setTreatmentPrice(String treatmentPrice) {
        this.treatmentPrice = treatmentPrice;
    }

    public String getTreatmentPrice() {
        return treatmentPrice;
    }

    public String getDate() {
        return date;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getFysiotherapistName() {
        return fysiotherapistName;
    }

    public String getStatus() {
        return status;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getTreatmentCode() {
        return treatmentCode;
    }

    public int getTreatmentTime() {
        return treatmentTime;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setPhysiotherapist(String fysiotherapistName) {
        this.fysiotherapistName = fysiotherapistName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setTreatmentCode(String treatmentCode) {
        this.treatmentCode = treatmentCode;
    }

    public void setTreatmentTime(int treatmentTime) {
        this.treatmentTime = treatmentTime;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

}
