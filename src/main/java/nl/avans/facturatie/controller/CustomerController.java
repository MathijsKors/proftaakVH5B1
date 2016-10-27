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
import java.util.Date;
import java.util.List;
import nl.avans.facturatie.model.Customer;
import nl.avans.facturatie.service.CustomerService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;

@Controller
public class CustomerController {
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    String format = "yyyy-MM-dd";
    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    dateFormat.setLenient(false);
    CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat,true,format.length());

    binder.registerCustomEditor(Date.class, customDateEditor);
    }
    
//    @InitBinder
//    public void initBinder(final WebDataBinder binder){
//        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//    }

    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);;
    
    private final CustomerService customerService;
    private Customer customer;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @ModelAttribute("page")
    public String module() {
        return "customers";
    }

    // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
    @ModelAttribute("classActiveCustomer")
    public String highlightNavMenuItem(){ return "active"; };

    /**
     * Haal een lijst van Customers en toon deze in een view.
     * @param model
     * @return
     */
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String listCustomers(Model model) {
        logger.debug("listCustomers");
        // Zet de opgevraagde customers in het model
        model.addAttribute("customers", customerService.findAllCustomers());
        // Open de juiste view template als resultaat.
        return "views/customer/list";
    }

    /**
     * Hiermee open je de create view om een nieuwe customer aan te maken.
     *
     * @param customer Dit object wordt aan de view meegegeven. Het object wordt gevuld met de waarden uit het formulier.
     * @param model
     * @return
     */
    @RequestMapping(value="/customer/create", method = RequestMethod.GET)
    public String showCreateCustomerForm(final Customer customer, final ModelMap model) {
        logger.debug("showCreateCustomerForm");
        return "views/customer/create";
    }
    
    
    @RequestMapping(value="/customer/create", method = RequestMethod.POST)
    public String validateAndSaveCustomer(@Valid Customer customer, final BindingResult bindingResult, final ModelMap model) {
        logger.debug("validateAndSaveCustomer - adding customer = " + customer.getFullName());
        
        

        if (bindingResult.hasErrors()) {
            // Als er velden in het formulier zijn die niet correct waren ingevuld vinden we die hier.
            // We blijven dan op dezelfde pagina. De foutmeldingen worden daar getoond
            // (zie het create.html bestand.
            logger.debug("validateAndSaveCustomer - not added, bindingResult.hasErrors");
            return "views/customer/create";
        }
       
        //check of BSN al bestaat
        int status = customerService.findCustomerByBSN(customer.getBsnNumber());
                
        if(status >= 1){
            System.out.println("BSN is al ingebruik.");
            bindingResult.rejectValue("bsnNumber", "", "BSN is al ingebruik.");
            return "views/customer/create";
        }
        
        // Maak de customer aan via de customer
        Customer newCustomer = customerService.create(customer);
        if(newCustomer != null) {
            model.addAttribute("info", "Klant '" + newCustomer.getFirstName() + " " + newCustomer.getLastName() + "' is toegevoegd.");
        } else {
                logger.error("Klant kon niet gemaakt worden.");
                model.addAttribute("info", "Klant kon niet gemaakt worden.");
            }


        // We gaan de lijst met customers tonen, met een bericht dat de nieuwe customer toegevoegd is.
        // Zet de opgevraagde customers in het model
        model.addAttribute("customers", customerService.findAllCustomers());
        // Open de juiste view template als resultaat.
        return "views/customer/list";
    }
    
    @RequestMapping(value="/customer/{id}/edit", method = RequestMethod.GET)
    public String showEditCustomerForm(final Customer customer, final ModelMap model, @PathVariable int id) {
        logger.debug("showEditCustomerForm");
        model.addAttribute("customer", customerService.findCustomerById(id));
        return "views/customer/edit";
    }
    
    @RequestMapping(value="/customer/{id}/edit", method = RequestMethod.POST)
    public String validateAndSaveEditedCustomer(final ModelMap model, @Valid Customer customer, final BindingResult bindingResult, @PathVariable String id) {
        logger.info("validateAndSaveEditedCustomer - edited customer = " + customer.getFullName());

        
        //error handeling met het aanpassen van een gebruiker gaat nog niet goed!
        
        if (bindingResult.hasErrors()) {
            // Als er velden in het formulier zijn die niet correct waren ingevuld vinden we die hier.
            // We blijven dan op dezelfde pagina. De foutmeldingen worden daar getoond
            // (zie het create.html bestand.
            logger.info("validateAndSaveCustomer - not added, bindingResult.hasErrors");
            return "views/customer/edit";
        }
        
        customerService.edit(customer,Integer.parseInt(id));
        
        // We gaan de lijst met customers tonen, met een bericht dat de nieuwe customer toegevoegd is.
        // Zet de opgevraagde customers in het model
        model.addAttribute("customers", customerService.findAllCustomers());
        // Open de juiste view template als resultaat.
        return "views/customer/list";
    }
    

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public String deleteCustomer(Model model, @PathVariable String id) {
        logger.debug("deleteCustomer, id = " + id);

        // Delete de customer
        customerService.delete(Integer.parseInt(id));
        // We gaan de lijst met customers tonen, met een bericht dat de nieuwe customer toegevoegd is.
        // Zet de opgevraagde customers in het model
        model.addAttribute("customers", customerService.findAllCustomers());
        model.addAttribute("info", "Customer is verwijderd.");
        // Open de juiste view template als resultaat.
        return "views/customer/list";
    }

    /**
     * Haal het customer met gegeven ID uit de database en toon deze in een view.
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public String listOneCustomer(Model model, @PathVariable int id) {
        // Zet de opgevraagde waarden in het model
        model.addAttribute("customer", customerService.findCustomerById(id));
        return "views/customer/read";
    }

    @ExceptionHandler(value = SQLException.class)
    public ModelAndView handleError(HttpServletRequest req, SQLException ex) {
        // logger.error("Request: " + req.getRequestURL() + " raised " + ex);
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("title", "Exception in CustomerController");
        mav.addObject("url", req.getRequestURL());
        // Je kunt hier kiezen in welke view je een melding toont - op een
        // aparte pagina, of als alertbox op de huidige pagina.
         mav.setViewName("error/error");
//        mav.setViewName("views/customer/create");
        return mav;
    }
    
    /**
     * Retourneer alle customers. Wordt gebruikt bij het uitlenen van een boek,
     * om een uitlening aan een customer te koppelen.
     *
     * @return
     */
    public List<Customer> findAllCustomers() { return customerService.findAllCustomers(); }

}
