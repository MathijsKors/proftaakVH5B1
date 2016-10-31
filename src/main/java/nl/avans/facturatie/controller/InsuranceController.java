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
import nl.avans.facturatie.model.Insurance;
import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.InsuranceService;

@Controller
public class InsuranceController {
    
    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }    

    private final Logger logger = LoggerFactory.getLogger(InsuranceCompanyController.class);;

    private InsuranceService insuranceService;

    @Autowired
    public InsuranceController(InsuranceService insuranceService){
        this.insuranceService = insuranceService;
    }

    @ModelAttribute("page")
    public String module() {
        return "insurances";
    }

    // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
    @ModelAttribute("classActiveInsurance")
    public String highlightNavMenuItem(){ return "active"; };

    /**
     * Haal een lijst van verzekeringen en toon deze in een view.
     * @param model
     * @return
     */
    @RequestMapping(value = "/insurances", method = RequestMethod.GET)
    public String listInsurances(@ModelAttribute("user") User user, Model model) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }   
        
        logger.debug("listInsurances");
        // Zet de opgevraagde verzekeringen in het model
        model.addAttribute("insurances", insuranceService.findAllInsurances());
        // Open de juiste view template als resultaat.
        return "views/insurance/list";
    }

    /**
     * Hiermee open je de create view om een nieuwe verzekering aan te maken.
     *
     * @param insurance Dit object wordt aan de view meegegeven. Het object wordt gevuld met de waarden uit het formulier.
     * @param model
     * @return
     */
    @RequestMapping(value="/insurance/create", method = RequestMethod.GET)
    public String showCreateInsuranceForm(@ModelAttribute("user") User user,final Insurance insurance, final ModelMap model) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        logger.debug("showCreateInsuranceForm");
        return "views/insurance/create";
    }
    
    
    @RequestMapping(value="/insurance/create", method = RequestMethod.POST)
    public String validateAndSaveInsurance(@ModelAttribute("user") User user, @Valid Insurance insurance, final BindingResult bindingResult, final ModelMap model) {
       if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        logger.debug("validateAndSaveInsurance - adding insurance = " + insurance.getType());

        if (bindingResult.hasErrors()) {
            // Als er velden in het formulier zijn die niet correct waren ingevuld vinden we die hier.
            // We blijven dan op dezelfde pagina. De foutmeldingen worden daar getoond
            // (zie het create.html bestand.
            logger.debug("validateAndSaveInsurance - not added, bindingResult.hasErrors");
            return "views/insurance/create";
        }
        // Maak de verzekering aan via de verzekering
        Insurance newInsurance = insuranceService.create(insurance);
        if(newInsurance != null) {
            model.addAttribute("info", "Insurance '" + newInsurance.getType() + "' is toegevoegd.");
        } else {
            logger.error("Insurance kon niet gemaakt worden.");
            model.addAttribute("info", "Insurance kon niet gemaakt worden.");
        }
        // We gaan de lijst met verzekeringen tonen, met een bericht dat de nieuwe verzekering toegevoegd is.
        // Zet de opgevraagde verzekeringen in het model
        model.addAttribute("insurances", insuranceService.findAllInsurances());
        // Open de juiste view template als resultaat.
        return "views/insurance/list";
    }
    
    @RequestMapping(value="/insurance/{id}/edit", method = RequestMethod.GET)
    public String showEditInsuranceForm(@ModelAttribute("user") User user, final Insurance insurance, final ModelMap model, @PathVariable int id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        logger.debug("showEditInsuranceForm");
        model.addAttribute("insurance", insuranceService.findInsuranceById(id));
        return "views/insurance/edit";
    }
    
    @RequestMapping(value="/insurance/{id}/edit", method = RequestMethod.POST)
    public String validateAndSaveEditedInsurance(@ModelAttribute("user") User user, @Valid Insurance insurance, @PathVariable String id, final BindingResult bindingResult, final ModelMap model) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        
        logger.debug("validateAndSaveEditedInsurance - edited insurance = " + insurance.getType());

        if (bindingResult.hasErrors()) {
            // Als er velden in het formulier zijn die niet correct waren ingevuld vinden we die hier.
            // We blijven dan op dezelfde pagina. De foutmeldingen worden daar getoond
            // (zie het create.html bestand.
            logger.debug("validateAndSaveInsurance - not added, bindingResult.hasErrors");
            return "views/insurance/edit";
        }
        // Maak de verzekering aan via de verzekering
        
        insuranceService.edit(insurance,Integer.parseInt(id));
        
        // We gaan de lijst met verzekeringen tonen, met een bericht dat de nieuwe verzekering toegevoegd is.
        // Zet de opgevraagde verzekeringen in het model
        model.addAttribute("insurances", insuranceService.findAllInsurances());
        // Open de juiste view template als resultaat.
        return "views/insurance/list";
    }

    @RequestMapping(value = "/insurance/{id}", method = RequestMethod.DELETE)
    public String deleteInsurance(@ModelAttribute("user") User user, Model model, @PathVariable String id) {
        if (!user.isAuthenticated()) {
            return "redirect:/login";
        }
        
        logger.debug("deleteInsurance, id = " + id);

        // Delete de verzekering
        insuranceService.delete(Integer.parseInt(id));
        // We gaan de lijst met verzekeringen tonen, met een bericht dat de nieuwe verzekering toegevoegd is.
        // Zet de opgevraagde customers in het model
        model.addAttribute("insurances", insuranceService.findAllInsurances());
        model.addAttribute("info", "Insurance is verwijderd.");
        // Open de juiste view template als resultaat.
        return "views/insurance/list";
    }
    
    @RequestMapping(value = "/insurance/{id}", method = RequestMethod.GET)
    public String listOneInsurance(@ModelAttribute("user") User user, Model model, @PathVariable int id) {
        if (!user.isAuthenticated()) {
                    return "redirect:/login";
                }        

    // Zet de opgevraagde waarden in het model
        model.addAttribute("insurance", insuranceService.findInsuranceById(id));
        return "views/insurance/read";
    }

    @ExceptionHandler(value = SQLException.class)
    public ModelAndView handleError(HttpServletRequest req, SQLException ex) {
        // logger.error("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("title", "Exception in InsuranceController");
        mav.addObject("url", req.getRequestURL());
        // Je kunt hier kiezen in welke view je een melding toont - op een
        // aparte pagina, of als alertbox op de huidige pagina.
         mav.setViewName("error/error");
//        mav.setViewName("views/insurance/create");
        return mav;
    }
    

    /**
     * Retourneer alle verzekeringen. Wordt gebruikt bij het uitlenen van een boek,
     * om een uitlening aan een customer te koppelen.
     *
     * @return
     */
    public List<Insurance> findAllInsurances() { return insuranceService.findAllInsurances(); }

}