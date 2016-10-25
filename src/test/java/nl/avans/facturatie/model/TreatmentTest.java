/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import nl.avans.facturatie.model.Treatment;
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
        
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of TreatmentCode method, of class Treatment.
     */
    @Test
    public void testTreatmentCode() {
        
        Treatment treatment = new Treatment(1, "Naam");
        
        System.out.println("TreatmentCode");
        
        String expResult = "1, Naam";
        String result = treatment.toString();
        
        System.err.println("result:" + result);
        System.out.println("Expected result:" + expResult);
        
        assertEquals(expResult, result);

    }    
}
