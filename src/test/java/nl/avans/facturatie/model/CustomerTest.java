/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.beans.property.IntegerProperty;
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
    
    SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

        int customerID = 0;
        String bsnNumber = "1254698762";
        String firstName = "Voornaam";
        String lastName = "Achternaam";
        java.util.Date birthDate = new java.util.Date();
        String street = "Straatnaam";
        String houseNumber = "12";
        String city = "Stadnaam";
        String phoneNumber =  "0231625463";
        String emailAddress = "email@adres.com";
        String insurance = "Verzekering naam";
        double ownRisk = 500;
       
        Customer customer = new Customer(bsnNumber, firstName, lastName, birthDate, street, houseNumber, city, phoneNumber, emailAddress, insurance, ownRisk);
    
    
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
     * @throws java.text.ParseException
     */
    @Before
    public void setUp() throws ParseException {
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
        String expResult = bsnNumber;
        String result = customer.getBsnNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBsnNumber method, of class Customer.
     */
    @Test
    public void testSetBsnNumber() {
        System.out.println("setBsnNumber");
        customer.setBsnNumber(bsnNumber);
        String expResult = bsnNumber;
        String result = customer.getBsnNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName method, of class Customer.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = firstName;
        String result = customer.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class Customer.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        customer.setFirstName(firstName);
        String expResult = firstName;
        String result = customer.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Customer.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = lastName;
        String result = customer.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class Customer.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        customer.setLastName(lastName);
        String expResult = lastName;
        String result = customer.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBirthDate method, of class Customer.
     */
    @Test
    public void testGetBirthDate() {
        System.out.println("getBirthDate");
        Date expResult = birthDate;
        Date result = customer.getBirthDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBirthDate method, of class Customer.
     */
    @Test
    public void testSetBirthDate() {
        System.out.println("setBirthDate");
        customer.setBirthDate(birthDate);
        Date expResult = birthDate;
        Date result = customer.getBirthDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFullName method, of class Customer.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        String expResult = firstName+" "+lastName;
        String result = customer.getFullName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStreet method, of class Customer.
     */
    @Test
    public void testGetStreet() {
        System.out.println("getStreet");
        String expResult = street;
        String result = customer.getStreet();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStreet method, of class Customer.
     */
    @Test
    public void testSetStreet() {
        System.out.println("setStreet");
        customer.setStreet(street);
        String expResult = street;
        String result = customer.getStreet();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHouseNumber method, of class Customer.
     */
    @Test
    public void testGetHouseNumber() {
        System.out.println("getHouseNumber");
        String expResult = houseNumber;
        String result = customer.getHouseNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHouseNumber method, of class Customer.
     */
    @Test
    public void testSetHouseNumber() {
        System.out.println("setHouseNumber");
        customer.setHouseNumber(houseNumber);
        String expResult = houseNumber;
        String result = customer.getHouseNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCity method, of class Customer.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        String expResult = city;
        String result = customer.getCity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCity method, of class Customer.
     */
    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "";
        customer.setCity(city);
        String expResult = city;
        String result = customer.getCity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhoneNumber method, of class Customer.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        String expResult = phoneNumber;
        String result = customer.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhoneNumber method, of class Customer.
     */
    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        customer.setPhoneNumber(phoneNumber);
        String expResult = phoneNumber;
        String result = customer.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmailAddress method, of class Customer.
     */
    @Test
    public void testGetEmailAddress() {
        System.out.println("getEmailAddress");
        String expResult = emailAddress;
        String result = customer.getEmailAddress();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setEmailAddress method, of class Customer.
     */
    @Test
    public void testSetEmailAddress() {
        System.out.println("setEmailAddress");
        customer.setEmailAddress(emailAddress);
        String expResult = emailAddress;
        String result = customer.getEmailAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInsurance method, of class Customer.
     */
    @Test
    public void testGetInsurance() {
        System.out.println("getInsurance");
        String expResult = insurance;
        String result = customer.getInsurance();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInsurance method, of class Customer.
     */
    @Test
    public void testSetInsurance() {
        System.out.println("setInsurance");
        String insurance = "";
        customer.setInsurance(insurance);
        String expResult = insurance;
        String result = customer.getInsurance();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCustomerID method, of class Customer.
     */
    @Test
    public void testSetCustomerID() {
        System.out.println("setCustomerID");
        customer.setCustomerID(customerID);
        int expResult = customerID;
        int result = customer.getCustomerID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustomerID method, of class Customer.
     */
    @Test
    public void testGetCustomerID() {
        System.out.println("getCustomerID");
        int expResult = customerID;
        int result = customer.getCustomerID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOwnRisk method, of class Customer.
     */
    @Test
    public void testSetOwnRisk() {
        System.out.println("setOwnRisk");
        customer.setOwnRisk(ownRisk);
        double expResult = ownRisk;
        double result = customer.getOwnRisk();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getOwnRisk method, of class Customer.
     */
    @Test
    public void testGetOwnRisk() {
        System.out.println("getOwnRisk");
        double expResult = ownRisk;
        double result = customer.getOwnRisk();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getLastUpdated method, of class Customer.
     */
    @Test
    public void testGetLastUpdated() {
        System.out.println("getLastUpdated");
        Date expResult = null;
        Date result = customer.getLastUpdated();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Customer.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = customer;
        boolean expResult = true;
        boolean result = customer.equals(o);
        assertEquals(expResult, result);
    }
    
}
