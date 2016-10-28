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
import java.util.List;
import nl.avans.facturatie.model.InsuranceCompany;
import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.InsuranceCompanyService;

@Controller
@SessionAttributes (value = "user", types = {User.class} )
public class InsuranceCompanyController {

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }    
    
    private final Logger logger = LoggerFactory.getLogger(InsuranceCompanyController.class);;

    private InsuranceCompanyService insuranceCompanyService;

    @Autowired
    public InsuranceCompanyController(InsuranceCompanyService insuranceCompanyService){
        this.insuranceCompanyService = insuranceCompanyService;
    }

    @ModelAttribute("page")
    public String module() {
        return "insurancecompanies";
    }

    // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
    @ModelAttribute("classActiveInsuranceCompany")
    public String highlightNavMenuItem(){ return "active"; };

    /**
     * Haal een lijst van Customers en toon deze in een view.
     * @param model
     * @return
     */
    @RequestMapping(value = "/insurancecompanies", method = RequestMethod.GET)
    public String listInsuranceCompanies(@ModelAttribute("user") User user, Model model) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }        
        
        logger.debug("listInsuranceCompanies");
        // Zet de opgevraagde customers in het model
        model.addAttribute("insurancecompanies", insuranceCompanyService.findAllInsuranceCompanies());
        // Open de juiste view template als resultaat.
        return "views/insurancecompany/list";
    }

    /**
     * Hiermee open je de create view om een nieuwe customer aan te maken.
     *
     * @param customer Dit object wordt aan de view meegegeven. Het object wordt gevuld met de waarden uit het formulier.
     * @param model
     * @return
     */
    @RequestMapping(value="/insurancecompany/create", method = RequestMethod.GET)
    public String showCreateInsuranceCompanyForm(@ModelAttribute("user") User user, final InsuranceCompany insuranceCompany, final ModelMap model) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }        
        
        logger.debug("showCreateInsuranceCompanyForm");
        return "views/insurancecompany/create";
    }
    
    
    @RequestMapping(value="/insurancecompany/create", method = RequestMethod.POST)
    public String validateAndSaveInsuranceCompany(@ModelAttribute("user") User user, @Valid InsuranceCompany insuranceCompany, final BindingResult bindingResult, final ModelMap model) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }        
        
        logger.debug("validateAndSaveInsuranceCompany - adding insuranceCompany = " + insuranceCompany.getName());

        if (bindingResult.hasErrors()) {
            // Als er velden in het formulier zijn die niet correct waren ingevuld vinden we die hier.
            // We blijven dan op dezelfde pagina. De foutmeldingen worden daar getoond
            // (zie het create.html bestand.
            logger.debug("validateAndSaveInsuranceCompany - not added, bindingResult.hasErrors");
            return "views/insurancecompany/create";
        }
        // Maak de customer aan via de customer
        InsuranceCompany newInsuranceCompany = insuranceCompanyService.create(insuranceCompany);
        if(newInsuranceCompany != null) {
            model.addAttribute("info", "InsuranceCompany '" + newInsuranceCompany.getName() + "' is toegevoegd.");
        } else {
            logger.error("InsuranceCompany kon niet gemaakt worden.");
            model.addAttribute("info", "InsuranceCompany kon niet gemaakt worden.");
        }
        // We gaan de lijst met customers tonen, met een bericht dat de nieuwe customer toegevoegd is.
        // Zet de opgevraagde customers in het model
        model.addAttribute("insurancecompanies", insuranceCompanyService.findAllInsuranceCompanies());
        // Open de juiste view template als resultaat.
        return "views/insurancecompany/list";
    }

    @RequestMapping(value = "/insurancecompany/{id}", method = RequestMethod.DELETE)
    public String deleteInsuranceCompany(@ModelAttribute("user") User user, Model model, @PathVariable String id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }        
        
        logger.debug("deleteInsuranceCompany, id = " + id);

        // Delete de customer
        insuranceCompanyService.delete(Integer.parseInt(id));
        // We gaan de lijst met customers tonen, met een bericht dat de nieuwe customer toegevoegd is.
        // Zet de opgevraagde customers in het model
        model.addAttribute("insurancecompanies", insuranceCompanyService.findAllInsuranceCompanies());
        model.addAttribute("info", "InsuranceCompany is verwijderd.");
        // Open de juiste view template als resultaat.
        return "views/insurancecompany/list";
    }
    
    @RequestMapping(value = "/insurancecompany/{id}", method = RequestMethod.GET)
    public String listOneInsuranceCompany(@ModelAttribute("user") User user, Model model, @PathVariable int id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }        

        // Zet de opgevraagde waarden in het model
        model.addAttribute("insurancecompany", insuranceCompanyService.findInsuranceCompanyById(id));
        return "views/insurancecompany/read";
    }

    @ExceptionHandler(value = SQLException.class)
    public ModelAndView handleError(HttpServletRequest req, SQLException ex) {
        // logger.error("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("title", "Exception in InsuranceCompanyController");
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
    public List<InsuranceCompany> findAllInsuranceCompanies() { return insuranceCompanyService.findAllInsuranceCompanies(); }

}
