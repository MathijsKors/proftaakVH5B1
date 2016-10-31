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
        
    }    

    /**
     * Test of getTreatmentName method, of class Treatment.
     */
    @Test
    public void testGetTreatmentName() {
        System.out.println("getTreatmentName");
        Treatment instance = new Treatment();
        String expResult = "";
        String result = instance.getTreatmentName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTreatmentName method, of class Treatment.
     */
    @Test
    public void testSetTreatmentName() {
        System.out.println("setTreatmentName");
        String treatmentName = "";
        Treatment instance = new Treatment();
        instance.setTreatmentName(treatmentName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTreatmentCode method, of class Treatment.
     */
    @Test
    public void testSetTreatmentCode() {
        System.out.println("setTreatmentCode");
        String treatmentCode = "";
        Treatment instance = new Treatment();
        instance.setTreatmentCode(treatmentCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTreatmentCode method, of class Treatment.
     */
    @Test
    public void testGetTreatmentCode() {
        System.out.println("getTreatmentCode");
        Treatment instance = new Treatment();
        String expResult = "";
        String result = instance.getTreatmentCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Treatment.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        String price = "";
        Treatment instance = new Treatment();
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Treatment.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Treatment instance = new Treatment();
        String expResult = "";
        String result = instance.getPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSessions method, of class Treatment.
     */
    @Test
    public void testSetSessions() {
        System.out.println("setSessions");
        int sessions = 0;
        Treatment instance = new Treatment();
        instance.setSessions(sessions);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSessions method, of class Treatment.
     */
    @Test
    public void testGetSessions() {
        System.out.println("getSessions");
        Treatment instance = new Treatment();
        int expResult = 0;
        int result = instance.getSessions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSessionTime method, of class Treatment.
     */
    @Test
    public void testSetSessionTime() {
        System.out.println("setSessionTime");
        int sessionTime = 0;
        Treatment instance = new Treatment();
        instance.setSessionTime(sessionTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSessionTime method, of class Treatment.
     */
    @Test
    public void testGetSessionTime() {
        System.out.println("getSessionTime");
        Treatment instance = new Treatment();
        int expResult = 0;
        int result = instance.getSessionTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Treatment.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Treatment instance = new Treatment();
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
