/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

/**
 *
 * @author Tom Maljaars
 */
public class OwnRisk {

	private int amount;
    private int remnant;
    
    /**
     *
     * @param amount
     * @param remnant
     */
    public OwnRisk(int amount, int remnant){
        this.amount = amount;
        this.remnant = remnant;
    }    
	
    /**
     *
     * @return
     */
    public int getAmount() {
		return amount;
	}
	
    /**
     *
     * @param amount
     */
    public void setAmount(int amount) {
		this.amount = amount;
	}
	
    /**
     *
     * @return
     */
    public int getRemnant() {
		return remnant;
	}
	
    /**
     *
     * @param remnant
     */
    public void setRemnant(int remnant) {
		this.remnant = remnant;
	}
}