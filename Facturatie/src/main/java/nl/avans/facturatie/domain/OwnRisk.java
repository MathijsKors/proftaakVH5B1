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
public class OwnRisk {
    private int amount;
    private int remnant;
    
    public OwnRisk(int amount, int remnant){
        this.amount = amount;
        this.remnant = remnant;
    }
}
    

