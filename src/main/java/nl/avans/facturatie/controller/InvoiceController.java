/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import nl.avans.facturatie.model.Appointment;
import nl.avans.facturatie.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import nl.avans.facturatie.model.Invoice;
import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.AppointmentService;
import nl.avans.facturatie.service.CustomerService;
import nl.avans.facturatie.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	
//    private final Logger logger = LoggerFactory.getLogger(BillingService.class);;

    private final CustomerService customerService;
    private final InvoiceService invoiceService;
    private final AppointmentService appointmentService;
    
        
    @Autowired
    public InvoiceController(CustomerService customerService, InvoiceService invoiceService, AppointmentService appointmentService){
        this.customerService = customerService;
        this.invoiceService = invoiceService;
        this.appointmentService = appointmentService;
    }
  
        private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    
     /**
     * Haal een lijst van Appointments en toon deze in een view.
     * @param model
     * @return
     */
    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public String listAppointments(Model model) {
        //logger.info("listAppointments");
        // Zet de opgevraagde appointments in het model
        model.addAttribute("appointmentObj", new Appointment());
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        model.addAttribute("invoices", invoiceService.findAllInvoices());
        // Open de juiste view template als resultaat.
        return "views/invoice/list";
    }
    
    
    @RequestMapping(value="/invoice/{id}/editandcreate", method = RequestMethod.GET)
    public String showEditAppointmentForm(@ModelAttribute("user") User user, final Invoice invoice, final ModelMap model, @PathVariable String id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        Appointment appointment = appointmentService.findAppointmentById(id);
        model.addAttribute("appointment", appointment);
        logger.info(appointment.getAppointmentId() + "");
        
        return "views/invoice/editandcreate";
    }
    
    @RequestMapping(value="/invoice/{id}/editandcreate", method = RequestMethod.POST)
    public String validateAndSaveEditedAppointment(@ModelAttribute("user") User user, final ModelMap model, @Valid Invoice invoice, final BindingResult bindingResult, @PathVariable String id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
      
        //error handeling met het aanpassen van een gebruiker gaat nog niet goed!
        if (bindingResult.hasErrors()) {
            // Als er velden in het formulier zijn die niet correct waren ingevuld vinden we die hier.
            // We blijven dan op dezelfde pagina. De foutmeldingen worden daar getoond
            // (zie het create.html bestand.
            //logger.info("validateAndSaveCustomer - not added, bindingResult.hasErrors");
            return "views/invoice/editandcreate";
        }
        Appointment appointment = appointmentService.findAppointmentById(id);
        Customer customer = customerService.findCustomerById(appointment.getPatientId());

        // Maak de customer aan via de customer
        Invoice newInvoice = invoiceService.create(invoice, customer);
        if (newInvoice != null) {
            model.addAttribute("info", "Invoice  is toegevoegd.");
        } else {
            
            model.addAttribute("info", "Invoice kon niet gemaakt worden.");
        }
        
        
        model.addAttribute("appointmentObj", new Appointment());
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        model.addAttribute("invoices", invoiceService.findAllInvoices());
        
        
     
        return "views/invoice/list";
    }
    
    
    @RequestMapping(value="/invoice/create/{id}", method = RequestMethod.GET)
    public String createdAppointment(@ModelAttribute("user") User user, final ModelMap model, @Valid Invoice invoice, final BindingResult bindingResult, @PathVariable String id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        Appointment appointment = appointmentService.findAppointmentById(id);
        Customer customer = customerService.findCustomerById(appointment.getPatientId());

        // Maak de customer aan via de customer
        Invoice newInvoice = invoiceService.create(invoice, customer);

        // We gaan de lijst met customers tonen, met een bericht dat de nieuwe customer toegevoegd is.
        // Zet de opgevraagde customers in het model
        //model.addAttribute("appointments", appointmentService.findAllAppointments());
        model.addAttribute("invoices", invoiceService.findAllInvoices());
        // Open de juiste view template als resultaat.
        return "views/invoice/list";
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