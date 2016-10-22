/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

/**
 *
 * @author Dorian
 */
public class Insurance {
    private String type, profile;
    private int costpMonth;
    private int insnumber;
    
    public Insurance(int insnumber, String type, String profile, int costpMonth) {
        this.insnumber = insnumber;
        this.type = type;
        this.profile = profile;
        this.costpMonth = costpMonth;
    }

    public int getInsnumber(){
        return insnumber;
    }
    
    public String getType() {
        return type;
    }

    public String getProfile() {
        return profile;
    }

    public int getcostpMonth() {
        return costpMonth;
    }

    public void setInsnumber(int insnumber){
        this.insnumber = insnumber;
    }
     
    public void setType(String type) {
        this.type = type;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setcostpMonth(int costpMonth) {
        this.costpMonth = costpMonth;
    }      
}
