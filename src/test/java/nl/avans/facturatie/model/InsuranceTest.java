/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import nl.avans.facturatie.model.Insurance;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dorian
 */
public class InsuranceTest {
    
    public InsuranceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getType method, of class Insurance.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Insurance instance = new Insurance(1, "Type1", "Profiel1", 15);
        String expResult = "Type1";
        String result = instance.getType();
        assertEquals(expResult, result);     
    }    
    
    /**
     * Test of getProfile method, of class Insurance.
     */
    @Test
    public void testGetProfile() {
        System.out.println("getProfile");
        Insurance instance = new Insurance(1, "Type1", "Profiel1", 15);
        String expResult = "Profiel1";
        String result = instance.getProfile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getcostpMonth method, of class Insurance.
     */
    @Test
    public void testGetcostpMonth() {
        System.out.println("getcostpMonth");
        Insurance instance = new Insurance(1, "Type1", "Profiel1", 15);
        int expResult = 15;
        int result = instance.getcostpMonth();
        assertEquals(expResult, result);
    }


    /**
     * Test of setType method, of class Insurance.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "Type2";
        Insurance instance = new Insurance(1, "Type1", "Profiel1", 15);
        instance.setType(type);
    }

    /**
     * Test of setProfile method, of class Insurance.
     */
    @Test
    public void testSetProfile() {
        System.out.println("setProfile");
        String profile = "Type2";
        Insurance instance = new Insurance(1, "Type1", "Profiel1", 15);
        instance.setProfile(profile);
    }

    /**
     * Test of setcostpMonth method, of class Insurance.
     */
    @Test
    public void testSetcostpMonth() {
        System.out.println("setcostpMonth");
        int costpMonth = 16;
        Insurance instance = new Insurance(1, "Type1", "Profiel1", 15);
        instance.setcostpMonth(costpMonth);
    }    
}
