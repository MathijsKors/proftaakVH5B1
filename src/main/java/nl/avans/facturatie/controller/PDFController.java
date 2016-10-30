/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import nl.avans.facturatie.model.Invoice;
import nl.avans.facturatie.model.PdfCreator;
import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Dorian
 */
@Controller
@SessionAttributes (value = "user", types = {User.class} )
public class PDFController {

    private final Logger logger = LoggerFactory.getLogger(InvoiceService.class);;
    private final InvoiceService invoiceService;
    public String DEST = "results/Factuur.pdf";
    
    @Autowired
    public PDFController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    
    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }     

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        String format = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat, true, format.length());

        binder.registerCustomEditor(Date.class, customDateEditor);
    }
    
    @RequestMapping(value="/invoice/createpdf/{id}", method = RequestMethod.GET)
    public String createPDF(@ModelAttribute("user") User user, final ModelMap model, @PathVariable int id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        
        Invoice invoice = invoiceService.findInvoiceById(id);
        logger.info(invoice.toString());
        DEST = "results/Factuur" + invoice.getInvoiceID() + ".pdf";
        
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        
        try {
            new PdfCreator().createPdf(invoice, DEST);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(PDFController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        logger.info("Create pdf");
        try {
            Runtime.getRuntime().exec("explorer.exe /open," + "results\\factuur"+invoice.getInvoiceID()+".pdf");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(PDFController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        invoiceService.delete(id);
        
        //model.addAttribute("billings", billingService.findAllBillings());
        model.addAttribute("invoices", invoiceService.findAllInvoices());
        // Open de juiste view template als resultaat.
        return "views/billing/list";
        
    }
}

