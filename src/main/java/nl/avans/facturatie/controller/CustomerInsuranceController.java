package nl.avans.facturatie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import nl.avans.facturatie.model.Customer;
import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.CustomerInsuranceService;
import nl.avans.facturatie.service.CustomerService;

/**
 *
 * @author Bram Mathijssen
 */

public class CustomerInsuranceController {
    
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    
    private final CustomerInsuranceService customerInsuranceService;
    private final CustomerService customerService;
    private Customer customer;
    
    @Autowired
    public CustomerInsuranceController(CustomerInsuranceService customerInsuranceService, CustomerService customerService) {
        this.customerInsuranceService = customerInsuranceService;
        this.customerService = customerService;
        
    }
    
    @ModelAttribute("page")
    public String module() {
        return "searchpage";
    }

    // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
    @ModelAttribute("classActiveCustomer")
    public String highlightNavMenuItem() {
        return "active";
    }

    /**
     * Haal een lijst van Customers en toon deze in een view op de searchpage
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchpage", method = RequestMethod.GET)
    public String searchpage (Model model) {
       
        
        logger.info("searchpage");
        // Zet de opgevraagde customers in het model
        model.addAttribute("customerinsurance", customerService.findAllCustomers());
        // Open de juiste view template als resultaat.
        return "views/customerinsurance/list";
    }
    
    
    
}
