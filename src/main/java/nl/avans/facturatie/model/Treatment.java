/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Tom Maljaars
 */

public class Treatment {
    String treatmentCode;
    String treatmentName; 
    String price;
    int sessions;
    int sessionTime;

    public Treatment(String treatmentCode, String treatmentName, String price, int sessions, int sessionTime) {
        this.treatmentCode = treatmentCode;
        this.treatmentName = treatmentName;
        this.price = price;
        this.sessions = sessions;
        this.sessionTime = sessionTime;
    }

    public Treatment() {
    }

    public String getTreatmentName() {
        return treatmentName;
    }
    
    @XmlElement(name = "behandelingnaam")
    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }
    
    @XmlAttribute(name = "behandelcode")
    public void setTreatmentCode(String treatmentCode) {
        this.treatmentCode = treatmentCode;
    }
    
    public String getTreatmentCode() {
        return treatmentName;
    }
    
    @XmlElement(name = "tariefbehandeling")
    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getPrice() {
        return price;
    }
    
    @XmlElement(name = "aantalsessies")
    public void setSessions(int sessions) {
        this.sessions = sessions;
    }

    public int getSessions() {
        return sessions;
    }
    
    @XmlElement(name = "sessieduur")
    public void setSessionTime(int sessionTime) {
        this.sessionTime = sessionTime;
    }
    
    public int getSessionTime() {
        return sessionTime;
    }
    
    public void print() {
        System.out.println(this.treatmentCode + ": " + this.treatmentName + " | €" + this.price + " | " + this.sessionTime + " uur | " + this.sessions + " keer");
    }
    
}

