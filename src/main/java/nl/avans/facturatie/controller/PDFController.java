/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.annotation.Resource;
import nl.avans.facturatie.model.Invoice;
import nl.avans.facturatie.model.PdfCreator;
import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.AppointmentService;
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
import sun.util.logging.resources.logging;

/**
 *
 * @author Dorian
 */
@Controller
@SessionAttributes (value = "user", types = {User.class} )
public class PDFController {

    private final Logger logger = LoggerFactory.getLogger(InvoiceService.class);;
    private final InvoiceService invoiceService;
    private final AppointmentService appointmentService;

    /**
     *
     */
    public String DEST = "src\\main\\resources\\static\\Factuur.pdf";
   
    /**
     *
     * @param invoiceService
     * @param appointmentService
     */
    @Autowired
    public PDFController(InvoiceService invoiceService, AppointmentService appointmentService) {
        this.invoiceService = invoiceService;
        this.appointmentService = appointmentService;
    }
    
    /**
     *
     * @return
     */
    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }     

    /**
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        String format = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat, true, format.length());

        binder.registerCustomEditor(Date.class, customDateEditor);
    }
    
    /**
     *
     * @param user
     * @param model
     * @param id
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/invoice/createpdf/{id}", method = RequestMethod.GET)
    public String createPDF(@ModelAttribute("user") User user, final ModelMap model, @PathVariable int id) throws IOException {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        
        Invoice invoice = invoiceService.findInvoiceById(id);
        logger.info(invoice.toString());
        DEST = "src\\main\\resources\\static\\pdf\\factuur" + invoice.getInvoiceID() + ".pdf";
        
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        
        try {
            new PdfCreator().createPdf(invoice, DEST);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(PDFController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        logger.info("Create pdf");
        try {
            Runtime.getRuntime().exec("explorer.exe /open," + "src\\main\\resources\\static\\pdf\\factuur"+invoice.getInvoiceID()+".pdf");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(PDFController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        invoiceService.delete(id);

        
        model.addAttribute("id", id);
        // Open de juiste view template als resultaat.
        return "views/invoice/pdf";
        
    }
    
    private static void downloadUsingStream(String urlStr, String file) throws IOException{
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
}

