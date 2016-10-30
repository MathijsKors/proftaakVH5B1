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
public class InsuranceCompanyTest {
    
    public InsuranceCompanyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getName method, of class InsuranceCompany.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        InsuranceCompany instance = new InsuranceCompany("Verzekeringsbedrijf1", "Lovensdijkstraat 1", "4816SJ", "Breda", "0683972505", "verzekeringsbedrijf@hotmail.com", 0);
        String expResult = "Verzekeringsbedrijf1";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress method, of class InsuranceCompany.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        InsuranceCompany instance = new InsuranceCompany("Verzekeringsbedrijf1", "Lovensdijkstraat 1", "4816SJ", "Breda", "0683972505", "verzekeringsbedrijf@hotmail.com", 0);
        String expResult = "Lovensdijkstraat 1";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getZipCode method, of class InsuranceCompany.
     */
    @Test
    public void testGetZipCode() {
        System.out.println("getZipCode");
        InsuranceCompany instance = new InsuranceCompany("Verzekeringsbedrijf1", "Lovensdijkstraat 1", "4816SJ", "Breda", "0683972505", "verzekeringsbedrijf@hotmail.com", 0);
        String expResult = "4816SJ";
        String result = instance.getZipCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCity method, of class InsuranceCompany.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        InsuranceCompany instance = new InsuranceCompany("Verzekeringsbedrijf1", "Lovensdijkstraat 1", "4816SJ", "Breda", "0683972505", "verzekeringsbedrijf@hotmail.com", 0);
        String expResult = "Breda";
        String result = instance.getCity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTelnumber method, of class InsuranceCompany.
     */
    @Test
    public void testGetTelnumber() {
        System.out.println("getTelnumber");
        InsuranceCompany instance = new InsuranceCompany("Verzekeringsbedrijf1", "Lovensdijkstraat 1", "4816SJ", "Breda", "0683972505", "verzekeringsbedrijf@hotmail.com", 0);
        String expResult = "0683972505";
        String result = instance.getTelnumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class InsuranceCompany.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        InsuranceCompany instance = new InsuranceCompany("Verzekeringsbedrijf1", "Lovensdijkstraat 1", "4816SJ", "Breda", "0683972505", "verzekeringsbedrijf@hotmail.com", 0);
        String expResult = "verzekeringsbedrijf@hotmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class InsuranceCompany.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        InsuranceCompany instance = new InsuranceCompany("Verzekeringsbedrijf1", "Lovensdijkstraat 1", "4816SJ", "Breda", "0683972505", "verzekeringsbedrijf@hotmail.com", 0);
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class InsuranceCompany.
     */
    @Test
    public void testSetName() { 
        System.out.println("setName");
        String Name = "Verzekeringsbedrijf2";
        InsuranceCompany instance = new InsuranceCompany();
        instance.setName(Name);
        String expResult = "Verzekeringsbedrijf2";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAddress method, of class InsuranceCompany.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String Address = "Lovensdijkstraat 2";
        InsuranceCompany instance = new InsuranceCompany();
        instance.setAddress(Address);
        String expResult = "Lovensdijkstraat 2";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of setZipCode method, of class InsuranceCompany.
     */
    @Test
    public void testSetZipCode() {
        System.out.println("setZipCode");
        String Zipcode = "4816JD";
        InsuranceCompany instance = new InsuranceCompany();
        instance.setZipCode(Zipcode);
        String expResult = "4816JD";
        String result = instance.getZipCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCity method, of class InsuranceCompany.
     */
    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String City = "Rotterdam";
        InsuranceCompany instance = new InsuranceCompany();
        instance.setCity(City);
        String expResult = "Rotterdam";
        String result = instance.getCity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTelnumber method, of class InsuranceCompany.
     */
    @Test
    public void testSetTelnumber() {
        System.out.println("setTelnumber");
        String Telnumber = "0683972504";
        InsuranceCompany instance = new InsuranceCompany();
        instance.setTelnumber(Telnumber);
        String expResult = "0683972504";
        String result = instance.getTelnumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class InsuranceCompany.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String Email = "verzekeringsbedrijf2@hotmail.com";
        InsuranceCompany instance = new InsuranceCompany();
        instance.setEmail(Email);
        String expResult = "verzekeringsbedrijf2@hotmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class InsuranceCompany.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int InsuranceCompanyID = 1;
        InsuranceCompany instance = new InsuranceCompany();
        instance.setId(InsuranceCompanyID);
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }
 
}
