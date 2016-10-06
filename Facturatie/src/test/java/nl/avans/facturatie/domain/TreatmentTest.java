/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tom Maljaars
 */
public class TreatmentTest {
    
    public TreatmentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Treatment treatment = new Treatment(1, "Naam");
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of TreatmentCode method, of class Treatment.
     */
    @Test
    public void testTreatmentCode() {
        System.out.println("TreatmentCode");
        Treatment instance = null;
        String expResult = "1, Naam";
        String result = instance.TreatmentCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
