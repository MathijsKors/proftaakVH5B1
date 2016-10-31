/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Tom Maljaars
 */

public class TreatmentTest {
    
    
    String treatmentCode = "1";
    String treatmentName = "Knie behandeling"; 
    String price = "79,9";
    int sessions = 1;
    int sessionTime = 1;
    
    Treatment instance = new Treatment(treatmentCode, treatmentName, price, sessions, sessionTime);
    
    
    
    /**
     *
     */
    public TreatmentTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        
        
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
        
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
        
    }

    /**
     * Test of TreatmentCode method, of class Treatment.
     */
    @Test
    public void testTreatmentCode() {
        
    }    

    /**
     * Test of getTreatmentName method, of class Treatment.
     */
    @Test
    public void testGetTreatmentName() {
        System.out.println("getTreatmentName");
        String expResult = treatmentName;
        String result = instance.getTreatmentName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTreatmentName method, of class Treatment.
     */
    @Test
    public void testSetTreatmentName() {
        System.out.println("setTreatmentName");
        instance.setTreatmentName(treatmentName);
        String expResult = treatmentName;
        String result = instance.getTreatmentName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTreatmentCode method, of class Treatment.
     */
    @Test
    public void testSetTreatmentCode() {
        System.out.println("setTreatmentCode");
        instance.setTreatmentCode(treatmentCode);
        String expResult = treatmentCode;
        String result = instance.getTreatmentCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTreatmentCode method, of class Treatment.
     */
    @Test
    public void testGetTreatmentCode() {
        System.out.println("getTreatmentCode");
        String expResult = treatmentCode;
        String result = instance.getTreatmentCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrice method, of class Treatment.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        instance.setPrice(price);
        String expResult = price;
        String result = instance.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class Treatment.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        String expResult = price;
        String result = instance.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSessions method, of class Treatment.
     */
    @Test
    public void testSetSessions() {
        System.out.println("setSessions");
        int sessions = 0;
        instance.setSessions(sessions);
        int expResult = sessions;
        int result = instance.getSessions();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSessions method, of class Treatment.
     */
    @Test
    public void testGetSessions() {
        System.out.println("getSessions");
        int expResult = sessions;
        int result = instance.getSessions();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSessionTime method, of class Treatment.
     */
    @Test
    public void testSetSessionTime() {
        System.out.println("setSessionTime");
        int sessionTime = 0;
        instance.setSessionTime(sessionTime);
        int expResult = sessionTime;
        int result = instance.getSessionTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSessionTime method, of class Treatment.
     */
    @Test
    public void testGetSessionTime() {
        System.out.println("getSessionTime");
        int expResult = sessionTime;
        int result = instance.getSessionTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of print method, of class Treatment.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        instance.print();
    }
}
