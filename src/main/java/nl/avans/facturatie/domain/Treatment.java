/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.domain;

/**
 *
 * @author Tom Maljaars
 */
public class Treatment {
    
    private int treatmentID;
    private String treatmentName;

    public Treatment(int treatmentID, String treatmentName) {
        this.treatmentID = treatmentID;
        this.treatmentName = treatmentName;
    }
    
    public int TreatmentCode(){
        return treatmentID;
    }
    
    public String treatmentName(){
        return treatmentName();
    }
    
    public String toString(){
        return  treatmentID + ", " + treatmentName;
    }
    
}
