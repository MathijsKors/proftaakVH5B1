package nl.avans.facturatie.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Mathijs
 */
public class InvoiceTest {
    
    public InvoiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
      
    /**
     * Test of getInvoiceID method, of class Invoice.
     */
    @Test
    public void testGetInvoiceID() throws ParseException {
    	
    	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

        Date date1 = (Date) dateformat.parse("17/07/1989");
        Date date2 = (Date) dateformat.parse("15/10/2007");
        
        System.out.println("getInvoiceID");
        Invoice instance = new Invoice(1, 10, "Harry", "Woord", "Basic", "Lovensdijkstraat2", 10, 15, date1, date2, "2");
        int expResult = 1;
        int result = instance.getInvoiceID();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getDuration method, of class Invoice.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        Date date1 = null;
		Date date2 = null;
		Invoice instance = new Invoice(1, 10, "Harry", "Woord", "Basic", "Lovensdijkstraat2", 10, 15, date1, date2, "2");
        int expResult = 10;
        int result = instance.getDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustomerName method, of class Invoice.
     */
    @Test
    public void testGetCustomerName() {
        System.out.println("getCustomerName");
        Date date1 = null;
		Date date2 = null;
        Invoice instance = new Invoice(1, 10, "Harry", "Woord", "Basic", "Lovensdijkstraat2", 10, 15, date1, date2, "2");
        String expResult = "4816SJ";
        String result = instance.getCustomerName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTreatmentName method, of class Invoice.
     */
    @Test
    public void testGetTreatmentName() {
        System.out.println("getTreatmentName");
        Date date1 = null;
		Date date2 = null;
        Invoice instance = new Invoice(1, 10, "Harry", "Woord", "Basic", "Lovensdijkstraat2", 10, 15, date1, date2, "2");
        String expResult = "Breda";
        String result = instance.getTreatmentName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInsuranceType method, of class Invoice.
     */
    @Test
    public void testGetInsuranceType() {
        System.out.println("testGetInsuranceType");
        Date date1 = null;
		Date date2 = null;
        Invoice instance = new Invoice(1, 10, "Harry", "Woord", "Basic", "Lovensdijkstraat2", 10, 15, date1, date2, "2");
        String expResult = "Basic";
        String result = instance.getInsuranceType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAdress method, of class Invoice.
     */
    @Test
    public void testGetAdress() {
        System.out.println("getAdress");
        Date date1 = null;
		Date date2 = null;
        Invoice instance = new Invoice(1, 10, "Harry", "Woord", "Basic", "Lovensdijkstraat2", 10, 15, date1, date2, "2");
        String expResult = "verzekeringsbedrijf@hotmail.com";
        String result = instance.getAdress();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getTotalPrice method, of class Invoice.
     */
    @Test
    public void testGetAppointmentId() {
        System.out.println("getAppointmentId");
        Date date1 = null;
		Date date2 = null;
        Invoice instance = new Invoice(1, 10, "Harry", "Woord", "Basic", "Lovensdijkstraat2", 10, 15, date1, date2, "2");
        String expResult = "Verzekeringsbedrijf1";
        String result = instance.getAppointmentId();
        assertEquals(expResult, result);
    }
    
    //Setters
    /**
     * Test of setInvoiceID method, of class Invoice.
     */
    @Test
    public void testSetInvoiceID() {
        System.out.println("getInvoiceID");
        int InvoiceID = 11;
        Invoice instance = new Invoice();
        instance.setInvoiceID(InvoiceID);
        int expResult = 11;
        int result = instance.getInvoiceID();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setDuration method, of class Invoice.
     */
    @Test
    public void testSetDuration() {
        System.out.println("getDuration");
        int Duration = 3;
        Invoice instance = new Invoice();
        instance.setDuration(Duration);
        int expResult = 3;
        int result = instance.getDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCustomerName method, of class Invoice.
     */
    @Test
    public void testSetCustomerName() {
        System.out.println("getCustomerName");
        String CustomerName = "Mario";
        Invoice instance = new Invoice();
        instance.setCustomerName(CustomerName);
        String expResult = "Mario";
        String result = instance.getCustomerName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTreatmentName method, of class Invoice.
     */
    @Test
    public void testSetTreatmentName() {
        System.out.println("getTreatmentName");
        String TreatmentName = "Hamstring";
        Invoice instance = new Invoice();
        instance.setTreatmentName(TreatmentName);
        String expResult = "Hamstring";
        String result = instance.getTreatmentName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInsuranceType method, of class Invoice.
     */
    @Test
    public void testSetInsuranceType() {
        System.out.println("testSetInsuranceType");
        String InsuranceType = "BasisPlus";
        Invoice instance = new Invoice();
        instance.setInsuranceType(InsuranceType);
        String expResult = "BasisPlus";
        String result = instance.getInsuranceType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdress method, of class Invoice.
     */
    @Test
    public void testSetAdress() {
        System.out.println("getAdress");
        String Adress = "Hogeschoollaan23";
        Invoice instance = new Invoice();
        instance.setAdress(Adress);
        String expResult = "Hogeschoollaan23";
        String result = instance.getAdress();
        assertEquals(expResult, result);
    }
}
