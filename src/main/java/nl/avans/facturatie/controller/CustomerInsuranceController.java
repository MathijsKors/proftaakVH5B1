package nl.avans.facturatie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import nl.avans.facturatie.model.Customer;
import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.CustomerService;
import nl.avans.facturatie.service.CustomerInsuranceService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;


/**
 *
 * @author Bram Mathijssen
 */

public class CustomerInsuranceController {
    
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    ;
    
    private final CustomerInsuranceService customerInsuranceService;
    private Customer customer;
    
    @Autowired
    public CustomerInsuranceController(CustomerInsuranceService customerInsuranceService) {
        this.customerInsuranceService = customerInsuranceService;
    }
    
    @ModelAttribute("page")
    public String module() {
        return "customers";
    }

    // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
    @ModelAttribute("classActiveCustomer")
    public String highlightNavMenuItem() {
        return "active";
    }

    ;

    /**
     * Haal een lijst van Customers en toon deze in een view op de searchpage
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchpage", method = RequestMethod.GET)
    public String listCustomers(@ModelAttribute("user") User user, Model model) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        logger.debug("listCustomers");
        // Zet de opgevraagde customers in het model
        model.addAttribute("customerinsurance", customerInsuranceService.findAllCustomers());
        // Open de juiste view template als resultaat.
        return "views/customerinsurance/list";
    }
    
    //de controllers voor het koppelen van een verzekering aan een klant
    @RequestMapping(value="/customer/{id}/editinsurance", method = RequestMethod.GET)
    public String showEditCustomerInsuranceForm(@ModelAttribute("user") User user, final Customer customer, final ModelMap model, @PathVariable int id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        logger.debug("showEditCustomerInsuranceForm");
        model.addAttribute("customer", customerInsuranceService.findCustomerById(id));
        return "views/customer/editinsurance";
    }
    
    @RequestMapping(value="/customer/{id}/editinsurance", method = RequestMethod.POST)
    public String validateAndSaveEditedCustomerInsurance(@ModelAttribute("user") User user, final ModelMap model, @Valid Customer customer, final BindingResult bindingResult, @PathVariable String id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        logger.info("validateAndSaveEditedCustomerInsurance - edited customer = " + customer.getFullName());

        //error handeling met het aanpassen van een gebruiker gaat nog niet goed!
        if (bindingResult.hasErrors()) {
            // Als er velden in het formulier zijn die niet correct waren ingevuld vinden we die hier.
            // We blijven dan op dezelfde pagina. De foutmeldingen worden daar getoond
            // (zie het create.html bestand.
            logger.info("validateAndSaveCustomer - not added, bindingResult.hasErrors");
            return "views/customer/editinsurance";
        }

        customerInsuranceService.edit(customer, Integer.parseInt(id));

        // We gaan de lijst met customers tonen, met een bericht dat de nieuwe customer toegevoegd is.
        // Zet de opgevraagde customers in het model
        model.addAttribute("customers", customerInsuranceService.findAllCustomers());
        // Open de juiste view template als resultaat.
        return "views/customer/list";
    }
    
}
