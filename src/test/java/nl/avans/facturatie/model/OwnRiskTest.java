package nl.avans.facturatie.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mathijs
 */
public class OwnRiskTest {
    
    public OwnRiskTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
      
    /**
     * Test of getAmount method, of class OwnRisk.
     */
    @Test
    public void testGetAmount() {        
        System.out.println("getAmount");
        OwnRisk instance = new OwnRisk(25, 50);
        int expResult = 25;
        int result = instance.getAmount();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getRemnant method, of class OwnRisk.
     */
    @Test
    public void testGetRemnant() {
        System.out.println("getRemnant");
        OwnRisk instance = new OwnRisk(25, 50);
        int expResult = 50;
        int result = instance.getRemnant();
        assertEquals(expResult, result);
    }

    //Test setters
    /**
     * Test of setAmount method, of class OwnRisk.
     */
    @Test
    public void testSetAmount() {
        System.out.println("testSetAmount");
        int Amount = 20;
        OwnRisk instance = new OwnRisk(20, 20);
        instance.setAmount(Amount);
        int expResult = 20;
        int result = instance.getAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRemnant method, of class OwnRisk.
     */
    @Test
    public void testSetRemnant() {
        System.out.println("getRemnant");
        int Remnant = 11;
        OwnRisk instance = new OwnRisk(11, 11);
        instance.setRemnant(Remnant);
        int expResult = 1;
        int result = instance.getRemnant();
        assertEquals(expResult, result);
    }
}
