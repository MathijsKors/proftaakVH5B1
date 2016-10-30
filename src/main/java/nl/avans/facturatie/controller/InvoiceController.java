/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import nl.avans.facturatie.model.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import nl.avans.facturatie.model.Billing;
import nl.avans.facturatie.model.Customer;
import nl.avans.facturatie.model.Invoice;
import nl.avans.facturatie.model.Treatment;
import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.AppointmentService;
import nl.avans.facturatie.service.BillingService;
import nl.avans.facturatie.service.CustomerService;
import nl.avans.facturatie.service.InvoiceService;
import nl.avans.facturatie.service.TreatmentService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Tom Maljaars
 */

@Controller
@SessionAttributes (value = "user", types = {User.class} )
public class InvoiceController {
    
    @ModelAttribute("user")
    public User getUser() {
        return new User();
    } 
	
    private final Logger logger = LoggerFactory.getLogger(BillingService.class);;

    private final BillingService billingService;
    private final CustomerService customerService;
    private final InvoiceService invoiceService;
    private final TreatmentService treatmentService;
    private final AppointmentService appointmentService;
        
    @Autowired
    public InvoiceController(BillingService billingService, CustomerService customerService, InvoiceService invoiceService, TreatmentService treatmentService, AppointmentService appointmentService){
        this.billingService = billingService;
        this.customerService = customerService;
        this.invoiceService = invoiceService;
        this.treatmentService = treatmentService;
        this.appointmentService = appointmentService;
    }
  
    @RequestMapping(value="/invoice/create/{id}", method = RequestMethod.GET)
    public String validateAndSaveInvoice(@ModelAttribute("user") User user, final ModelMap model, @PathVariable int id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        Billing bill = billingService.findBillingById(id);
        Customer customer = customerService.findCustomerById(bill.getCustomerID());
        Treatment treatment = treatmentService.findTreatmentById(bill.getTreatmentID()+"");
        //Appointment appointment = appointmentService.findAppointmentById(id)ById(bill.getTreatmentID()+"");
        
        // Maak de invoice aan via de invoiceservice
        Invoice newInvoice = invoiceService.create(bill, customer, treatment);
        billingService.delete(id);
        
        if (newInvoice != null) {
            model.addAttribute("info", "Invoice is toegevoegd.");
        } else {
            logger.error("Klant kon niet gemaakt worden.");
            model.addAttribute("info", "Klant kon niet gemaakt worden.");
        }

        // We gaan de lijst met invoices tonen, met een bericht dat de nieuwe invoice toegevoegd is.
        // Zet de opgevraagde invoices in het model
        model.addAttribute("billings", billingService.findAllBillings());
        model.addAttribute("invoices", invoiceService.findAllInvoices());
        // Open de juiste view template als resultaat.
        return "views/billing/list";
    }
    
    @ExceptionHandler(value = SQLException.class)
    public ModelAndView handleError(HttpServletRequest req, SQLException ex) {
        // logger.error("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("title", "Exception in BillingController");
        mav.addObject("url", req.getRequestURL());
        // Je kunt hier kiezen in welke view je een melding toont - op een
        // aparte pagina, of als alertbox op de huidige pagina.
         mav.setViewName("error/error");
//        mav.setViewName("views/billing/create");
        return mav;
    }
    
    /**
     * Retourneer alle rekeningen. Wordt gebruikt om uiteindelijk een rekening aan een klant te 
     *
     * @return
     */
    public List<Invoice> findAllInvoices() { return invoiceService.findAllInvoices(); }
    
}