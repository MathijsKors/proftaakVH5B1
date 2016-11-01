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
public class AppointmentTest {
    
    /**
     *
     */
    public AppointmentTest() {
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
     * Test of setFysiotherapistName method, of class Appointment.
     */
    @Test
    public void testSetPhysiotherapistName() {
        System.out.println("setFysiotherapistName");
        Appointment instance = new Appointment();
        String name = "Karel";
        instance.setPhysiotherapist(name);
        String expResult = "Karel";
        String result = instance.getFysiotherapistName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setTreatmentPrice method, of class Appointment.
     */
    @Test
    public void testSetTreatmentPrice() {
        System.out.println("setTreatmentPrice");
        Appointment instance = new Appointment();
        String price = "50";
        instance.setTreatmentPrice(price);
        String expResult = "50";
        String result = instance.getTreatmentPrice();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getDate method, of class Appointment.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        String expResult = "17-11-2016";
        String result = instance.getDate();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getAppointmentID method, of class Appointment.
     */
    @Test
    public void testAppointmentID() {
        System.out.println("getAppointmentID");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        String expResult = "5";
        String result = instance.getAppointmentId();
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of getStatus method, of class Appointment.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        String expResult = "open";
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of getPatientName method, of class Appointment.
     */
    @Test
    public void testGetPatientName() {
        System.out.println("getPatientName");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        String expResult = "Missy";
        String result = instance.getPatientName();
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of getDate method, of class Appointment.
     */
    @Test
    public void testGetTreatmentCode() {
        System.out.println("getTreatmentCode");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        String expResult = "1A";
        String result = instance.getTreatmentCode();
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of getTreatmentTime method, of class Appointment.
     */
    @Test
    public void testGetTreatmentTime() {
        System.out.println("getTreatmentTime");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        int expResult = 20;
        int result = instance.getTreatmentTime();
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of getPatientID method, of class Appointment.
     */
    @Test
    public void testPatientID() {
        System.out.println("getPatientID");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        int expResult = 1;
        int result = instance.getPatientId();
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of getTreatmentName method, of class Appointment.
     */
    @Test
    public void testGetTreatmentName() {
        System.out.println("getTreatmentName");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        String expResult = "Schoktherapie";
        String result = instance.getTreatmentName();
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of setDate method, of class Appointment.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        String newDate = "18-11-2016";
        instance.setDate(newDate);
        String expResult = newDate;
        String result = instance.getDate();
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of setAppointmentID method, of class Appointment.
     */
    @Test
    public void testSetAppointmentID() {
        System.out.println("setAppointmentID");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        String newID = "3";
        instance.setAppointmentId(newID);
        String expResult = newID;
        String result = instance.getAppointmentId();
        assertEquals(expResult, result);
    }  
    
    /**
     * Test of setStatus method, of class Appointment.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        String newStatus = "Betaald";
        instance.setStatus(newStatus);
        String expResult = newStatus;
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }  
    
    /**
     * Test of setPatientName method, of class Appointment.
     */
    @Test
    public void testSetPatientName() {
        System.out.println("setPatientName");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        String newName = "Brock";
        instance.setPatientName(newName);
        String expResult = newName;
        String result = instance.getPatientName();
        assertEquals(expResult, result);
    }      
    
    /**
     * Test of setTreatmentCode method, of class Appointment.
     */
    @Test
    public void testSetTreatmentCode() {
        System.out.println("setTreatmentCode");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        String newCode = "2B";
        instance.setTreatmentCode(newCode);
        String expResult = newCode;
        String result = instance.getTreatmentCode();
        assertEquals(expResult, result);
    }      
    
    /**
     * Test of setTreatmentTime method, of class Appointment.
     */
    @Test
    public void testSetTreatmentTime() {
        System.out.println("setTreatmentTime");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        int newTime = 30;
        instance.setTreatmentTime(newTime);
        int expResult = newTime;
        int result = instance.getTreatmentTime();
        assertEquals(expResult, result);
    }      
    
    /**
     * Test of setPatientID method, of class Appointment.
     */
    @Test
    public void testSetPatientID() {
        System.out.println("setPatientID");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        int newID = 3;
        instance.setPatientId(newID);
        int expResult = newID;
        int result = instance.getPatientId();
        assertEquals(expResult, result);
    }      
    
    /**
     * Test of setTreatmentName method, of class Appointment.
     */
    @Test
    public void testSetTreatmentName() {
        System.out.println("setTreatmentName");
        Appointment instance = new Appointment("17-11-2016", "5", "Timothy", "open", "Missy", "1A", 20, 1, "Schoktherapie", "50");
        String newName = "Schouder";
        instance.setTreatmentName(newName);
        String expResult = newName;
        String result = instance.getTreatmentName();
        assertEquals(expResult, result);
    }      
    
}
