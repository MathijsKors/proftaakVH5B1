/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dorian
 */
public class FysioRestTest {

    /**
     *
     */
    public FysioRestTest() {
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
     * Test of getDateObject method, of class FysioRest.
     */
    @Test
    public void testGetDateObject() {
        System.out.println("getDateObject");
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        String expResult = "Date";
        String result = instance.getDateObject();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateObject method, of class FysioRest.
     */
    @Test
    public void testSetDateObject() {
        System.out.println("setDateObject");
        String dateObject = "Date2";
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        instance.setDateObject(dateObject);
        String expResult = "Date2";
        String result = instance.getDateObject();
        assertEquals(expResult, result);

    }

    /**
     * Test of getStatus method, of class FysioRest.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        String expResult = "Done";
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStatus method, of class FysioRest.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "Not started";
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        instance.setStatus(status);
        String expResult = "Not started";
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhysiotherapist method, of class FysioRest.
     */
    @Test
    public void testGetPhysiotherapist() {
        System.out.println("getPhysiotherapist");
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        String expResult = "Tom";
        String result = instance.getPhysiotherapist();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhysiotherapist method, of class FysioRest.
     */
    @Test
    public void testSetPhysiotherapist() {
        System.out.println("setPhysiotherapist");
        String physiotherapistName = "Kevin";
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        instance.setPhysiotherapist(physiotherapistName);
        String expResult = "Kevin";
        String result = instance.getPhysiotherapist();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class FysioRest.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        String expResult = "12-12-16";
        String result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDate method, of class FysioRest.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "11-11-16";
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        instance.setDate(date);
        String expResult = "11-11-16";
        String result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPatientId method, of class FysioRest.
     */
    @Test
    public void testGetPatientId() {
        System.out.println("getPatientId");
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        String expResult = "33";
        String result = instance.getPatientId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPatientId method, of class FysioRest.
     */
    @Test
    public void testSetPatientId() {
        System.out.println("setPatientId");
        String patientId = "40";
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        instance.setPatientId(patientId);
        String expResult = "40";
        String result = instance.getPatientId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPatientName method, of class FysioRest.
     */
    @Test
    public void testGetPatientName() {
        System.out.println("getPatientName");
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        String expResult = "Jan";
        String result = instance.getPatientName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPatientName method, of class FysioRest.
     */
    @Test
    public void testSetPatientName() {
        System.out.println("setPatientName");
        String patientName = "Henk";
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        instance.setPatientName(patientName);
        String expResult = "Henk";
        String result = instance.getPatientName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTreatmentName method, of class FysioRest.
     */
    @Test
    public void testGetTreatmentName() {
        System.out.println("getTreatmentName");
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        String expResult = "Gebroken been";
        String result = instance.getTreatmentName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTreatmentName method, of class FysioRest.
     */
    @Test
    public void testSetTreatmentName() {
        System.out.println("setTreatmentName");
        String treatmentName = "Gebroken arm";
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        instance.setTreatmentName(treatmentName);
        String expResult = "Gebroken arm";
        String result = instance.getTreatmentName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAppointmentId method, of class FysioRest.
     */
    @Test
    public void testGetAppointmentId() {
        System.out.println("getAppointmentId");
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        String expResult = "25";
        String result = instance.getAppointmentId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAppointmentId method, of class FysioRest.
     */
    @Test
    public void testSetAppointmentId() {
        System.out.println("setAppointmentId");
        String appointmentId = "10";
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        instance.setAppointmentId(appointmentId);
        String expResult = "10";
        String result = instance.getAppointmentId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTreatmentCode method, of class FysioRest.
     */
    @Test
    public void testGetTreatmentCode() {
        System.out.println("getTreatmentCode");
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        String expResult = "3";
        String result = instance.getTreatmentCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTreatmentCode method, of class FysioRest.
     */
    @Test
    public void testSetTreatmentCode() {
        System.out.println("setTreatmentCode");
        String treatmentCode = "30";
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        instance.setTreatmentCode(treatmentCode);
        String expResult = "30";
        String result = instance.getTreatmentCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTreatmentTime method, of class FysioRest.
     */
    @Test
    public void testGetTreatmentTime() {
        System.out.println("getTreatmentTime");
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        String expResult = "5";
        String result = instance.getTreatmentTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTreatmentTime method, of class FysioRest.
     */
    @Test
    public void testSetTreatmentTime() {
        System.out.println("setTreatmentTime");
        String treatmentTime = "8";
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        instance.setTreatmentTime(treatmentTime);
        String expResult = "8";
        String result = instance.getTreatmentTime();
        assertEquals(expResult, result);
    }
}
