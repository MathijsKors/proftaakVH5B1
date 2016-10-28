/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dyl
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User("jaap", "hoi", false);
        String expResult = "jaap";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "bart";
        User instance = new User("tim", "appelflap", false);
        instance.setUsername(username);
        String expResult = "bart";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User("dylan", "cool", false);
        String expResult = "cool";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "wachtwoord";
        User instance = new User("dorian", "macho", false);
        instance.setPassword(password);
        String expResult = "wachtwoord";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAuthenticated method, of class User.
     */
    @Test
    public void testIsAuthenticated() {
        System.out.println("isAuthenticated");
        User instance = new User("tess", "topper", false);
        boolean expResult = false;
        boolean result = instance.isAuthenticated();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setAuthenticated method, of class User.
     */
    @Test
    public void testSetAuthenticated() {
        System.out.println("setAuthenticated");
        boolean authenticated = true;
        User instance = new User("dora", "dikkerd", false);
        instance.setAuthenticated(authenticated);
        boolean expResult = true;
        boolean result = instance.isAuthenticated();
        assertEquals(expResult, result);
    }
    
}
