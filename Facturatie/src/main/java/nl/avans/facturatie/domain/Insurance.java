/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.domain;

/**
 *
 * @author Dorian
 */
public class Insurance {
    private String type, profile;
    private int costpMonth;
    
    public Insurance(String type, String profile, int costpMonth) {
        this.type = type;
        this.profile = profile;
        this.costpMonth = costpMonth;
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
