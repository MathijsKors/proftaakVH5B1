/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

/**
 *
 * @author dyl
 */
public class User {
    private String userName, password;
    
    public User (String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public String getName() {
        return userName;
    }
    
}
