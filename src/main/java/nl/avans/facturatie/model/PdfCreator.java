package nl.avans.facturatie.model;

import java.util.Date;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;




/**
 * Simple pdf example.
 */
public class PdfCreator {
 
	// Generating random String to save pdf	
	/**private static String FILE = "results/Factuur.pdf";
	DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss"); 
	String filename = FILE.split(".")[0] + df.format(new Date()) + FILE.split(".")[1];
	*/
    
    public final String DEST = "\\src\\main\\resources\\static\\pdf\\Factuur.pdf";
    
    /**
     *
     * @param invoice
     * @param DEST
     * @throws FileNotFoundException
     */
    public void createPdf(Invoice invoice, String DEST) throws FileNotFoundException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(DEST);

 
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
 
        //Initialize document
        Document document = new Document(pdf);
        
        //Add paragraph to the document
        document.add(new Paragraph("Factuur"));
        document.add(new Paragraph("---------------------------------------------------"));
        
        //Add Date to document
        document.add(new Paragraph(new Date().toString()));
        document.add(new Paragraph("---------------------------------------------------"));
        
        // Customer section
        // Add new list of Customer details
        document.add(new Paragraph("Klantgegevens"));
        List list = new List();
        list.setListSymbol("");
        list.add(new ListItem("Naam: " + invoice.getCustomerName()));
        list.add(new ListItem("Adres: " + invoice.getAdress()));
        list.add(new ListItem("-------------------------"));

        
        document.add(list);
        
        //Add new list of Invoice details
        document.add(new Paragraph("Factuurgegevens"));
        List list2 = new List();
        list2.setListSymbol("");
        list2.add(new ListItem("Factuurnummer: " + invoice.getInvoiceID()));
        list2.add(new ListItem("Factuurdatum: " + invoice.getInvoiceDate()));
        list2.add(new ListItem("Verloopdatum: " + invoice.getDeadline()));
        
        document.add(list2);
        
        
        document.add(new Paragraph("---------------------------------------------------"));
        document.add(new Paragraph("Totaalprijs:         " + invoice.getTotalPrice()));
        
        //Close document
        
        document.close();

    }
}