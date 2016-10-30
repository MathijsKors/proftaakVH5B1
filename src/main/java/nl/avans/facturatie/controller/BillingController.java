/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.BillingService;
import nl.avans.facturatie.service.CustomerService;
import nl.avans.facturatie.service.InvoiceService;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Tom Maljaars
 */

@Controller
@SessionAttributes (value = "user", types = {User.class} )
public class BillingController {
    
    @ModelAttribute("user")
    public User getUser() {
        return new User();
    } 
	
    private final Logger logger = LoggerFactory.getLogger(BillingService.class);;

    private final BillingService billingService;
    private CustomerService customerService;
    private InvoiceService invoiceService;
    private Billing billing;
        
    @Autowired
    public BillingController(BillingService billingService, CustomerService customerService, InvoiceService invoiceService){
        this.billingService = billingService;
        this.customerService = customerService;
        this.invoiceService = invoiceService;
    }
   
    
    /**
     * Haal een lijst van Billings en toon deze in een view.
     * @param model
     * @return
     */
    @RequestMapping(value = "/billing", method = RequestMethod.GET)
    public String listBillings(Model model) {
        logger.info("listBillings");
        // Zet de opgevraagde billings in het model
        model.addAttribute("billings", billingService.findAllBillings());
        model.addAttribute("invoices", invoiceService.findAllInvoices());
        // Open de juiste view template als resultaat.
        return "views/billing/list";
    }

    /**
     * Haal de billing met gegeven ID uit de database en toon deze in een view.
     * @param model
     * @param id
     * @return
     */
     @RequestMapping(value = "/billing/{id}", method = RequestMethod.GET)
    public String listOneBilling(@ModelAttribute("user") User user, Model model, @PathVariable int id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }        

        // Zet de opgevraagde waarden in het model
        Billing bill = billingService.findBillingById(id);
        model.addAttribute("billing", bill);
        logger.info(bill.getCustomerID() + "");
        int customerID = bill.getCustomerID();
        model.addAttribute("customer", customerService.findCustomerById(customerID));
        return "views/billing/read";
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
    public List<Billing> findAllBillings() { return billingService.findAllBillings(); }
    
}