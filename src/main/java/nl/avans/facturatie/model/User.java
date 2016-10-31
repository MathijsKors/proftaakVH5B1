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
    
    /**
     *
     */
    public User() {
        this.authenticated = false;
    } 
    
    /**
     *
     * @param username
     * @param password
     * @param authenticated
     */
    public User(String username, String password, boolean authenticated) {
        this.username = username;
        this.password = password;
        this.authenticated = authenticated;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public boolean isAuthenticated() {
        if(User.debugAuthenticated) {
            return true;
        }
        
        return authenticated;
    }

    /**
     *
     * @param authenticated
     */
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
    
    
    
}
