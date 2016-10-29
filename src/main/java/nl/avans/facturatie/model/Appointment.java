/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import java.util.Date;

/**
 *
 * @author Dorian
 */
public class Appointment {

    private Date date;
    private int appointmentId;
    private String physiotherapist;
    private String status;
    private String patientName;
    private String treatmentCode;
    private int treatmentTime;
    private int patientId;
    private String treatmentName;

    
    public Appointment(){
    }
    
    public Appointment(Date date, int appointmentId, String physiotherapist, String status, String patientName, String treatmentCode, int treatmentTime, int patientId, String treatmentName) {
        this.date = date;
        this.appointmentId = appointmentId;
        this.physiotherapist = physiotherapist;
        this.status = status;
        this.patientName = patientName;
        this.treatmentCode = treatmentCode;
        this.treatmentTime = treatmentTime;
        this.patientId = patientId;
        this.treatmentName = treatmentName;
    }

    public Date getDate() {
        return date;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public String getPhysiotherapist() {
        return physiotherapist;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setPhysiotherapist(String physiotherapist) {
        this.physiotherapist = physiotherapist;
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
