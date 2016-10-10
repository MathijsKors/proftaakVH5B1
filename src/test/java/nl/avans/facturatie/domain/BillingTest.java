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
 * @author dyl
 */
public class BillingTest {
    private Billing b;
    
    public BillingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        java.sql.Date date1 = java.sql.Date.valueOf( "2016-01-01" );
        java.sql.Date date2 = java.sql.Date.valueOf( "2016-03-01" );
        Billing b = new Billing("Dylan Martens", "Leutlaan 12", "4615JX", "Breda", "Rugklachten", date1, date2, 400, 200, 200);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPrize method, of class Billing.
     */
    @Test
    public void testGetPrize() {
        System.out.println("getPrize");
        int expResult = 400;
        int result = b.getPrize();
        assertEquals(expResult, result);
    }

    /**
     * Test of lowerToBePaid method, of class Billing.
     */
    @Test
    public void testLowerToBePaid() {
        System.out.println("lowerToBePaid");
        int amount = 50;
        b.lowerToBePaid(amount); // 200 - 50 = 150
        int expResult = 150;
        int result = b.getPrize();
        assertEquals(expResult, result);
    }

    /**
     * Test of raiseToBePaid method, of class Billing.
     */
    @Test
    public void testRaiseToBePaid() {
        System.out.println("raiseToBePaid");
        int amount = 50;
        b.raiseToBePaid(amount); // 200 + 50 = 250
        int expResult = 250;
        int result = b.getPrize();
        assertEquals(expResult, result);
    }
    
}
