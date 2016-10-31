/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import java.util.Date;
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
public class CustomerTest {
    
    /**
     *
     */
    public CustomerTest() {
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
        //Customer customer = new Customer("1254698762", "Achternaam", 13-12-2016, "Straatnaam", 12, "Stadnaam", "0231625463", "email@adres.com", "Verzekering naam", 500);
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of getBsnNumber method, of class Customer.
     */
    @Test
    public void testGetBsnNumber() {
        System.out.println("getBsnNumber");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getBsnNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBsnNumber method, of class Customer.
     */
    @Test
    public void testSetBsnNumber() {
        System.out.println("setBsnNumber");
        String bsnNumber = "";
        Customer instance = new Customer();
        instance.setBsnNumber(bsnNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class Customer.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class Customer.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Customer instance = new Customer();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Customer.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class Customer.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Customer instance = new Customer();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBirthDate method, of class Customer.
     */
    @Test
    public void testGetBirthDate() {
        System.out.println("getBirthDate");
        Customer instance = new Customer();
        Date expResult = null;
        Date result = instance.getBirthDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
        
        System.out.println("getDateObject");
        FysioRest instance = new FysioRest("Date", "Done", "Tom", "12-12-16", "33", "Jan", "Gebroken been", "25", "3", "5");
        String expResult = "Date";
        String result = instance.getDateObject();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBirthDate method, of class Customer.
     */
    @Test
    public void testSetBirthDate() {
        System.out.println("setBirthDate");
        Date birthDate = null;
        Customer instance = new Customer();
        instance.setBirthDate(birthDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFullName method, of class Customer.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getFullName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStreet method, of class Customer.
     */
    @Test
    public void testGetStreet() {
        System.out.println("getStreet");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getStreet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStreet method, of class Customer.
     */
    @Test
    public void testSetStreet() {
        System.out.println("setStreet");
        String street = "";
        Customer instance = new Customer();
        instance.setStreet(street);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHouseNumber method, of class Customer.
     */
    @Test
    public void testGetHouseNumber() {
        System.out.println("getHouseNumber");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getHouseNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHouseNumber method, of class Customer.
     */
    @Test
    public void testSetHouseNumber() {
        System.out.println("setHouseNumber");
        String houseNumber = "";
        Customer instance = new Customer();
        instance.setHouseNumber(houseNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCity method, of class Customer.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getCity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCity method, of class Customer.
     */
    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "";
        Customer instance = new Customer();
        instance.setCity(city);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhoneNumber method, of class Customer.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhoneNumber method, of class Customer.
     */
    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        String phoneNumber = "";
        Customer instance = new Customer();
        instance.setPhoneNumber(phoneNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmailAddress method, of class Customer.
     */
    @Test
    public void testGetEmailAddress() {
        System.out.println("getEmailAddress");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getEmailAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmailAddress method, of class Customer.
     */
    @Test
    public void testSetEmailAddress() {
        System.out.println("setEmailAddress");
        String emailAddress = "";
        Customer instance = new Customer();
        instance.setEmailAddress(emailAddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInsurance method, of class Customer.
     */
    @Test
    public void testGetInsurance() {
        System.out.println("getInsurance");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getInsurance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInsurance method, of class Customer.
     */
    @Test
    public void testSetInsurance() {
        System.out.println("setInsurance");
        String insurance = "";
        Customer instance = new Customer();
        instance.setInsurance(insurance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerID method, of class Customer.
     */
    @Test
    public void testSetCustomerID() {
        System.out.println("setCustomerID");
        int customerID = 0;
        Customer instance = new Customer();
        instance.setCustomerID(customerID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerID method, of class Customer.
     */
    @Test
    public void testGetCustomerID() {
        System.out.println("getCustomerID");
        Customer instance = new Customer();
        int expResult = 0;
        int result = instance.getCustomerID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOwnRisk method, of class Customer.
     */
    @Test
    public void testSetOwnRisk() {
        System.out.println("setOwnRisk");
        double ownRisk = 0.0;
        Customer instance = new Customer();
        instance.setOwnRisk(ownRisk);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwnRisk method, of class Customer.
     */
    @Test
    public void testGetOwnRisk() {
        System.out.println("getOwnRisk");
        Customer instance = new Customer();
        double expResult = 0.0;
        double result = instance.getOwnRisk();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdated method, of class Customer.
     */
    @Test
    public void testGetLastUpdated() {
        System.out.println("getLastUpdated");
        Customer instance = new Customer();
        Date expResult = null;
        Date result = instance.getLastUpdated();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Customer.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Customer instance = new Customer();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
