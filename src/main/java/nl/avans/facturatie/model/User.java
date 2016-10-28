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

    //Set debugAuthenticated to true to activate debugging, where you can test the system without being logged in.
    private static boolean debugAuthenticated = false;
    //Credentials
    private String username, password;
    //Whether or not the user is logged in
    private boolean authenticated;
    
    public User() {
        this.authenticated = false;
    } 

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthenticated() {
        if(User.debugAuthenticated) {
            return true;
        }
        
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
    
    
    
}
