package nl.avans.facturatie.controller;

import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    
    private LoginService loginservice;
    private User user;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginForm(final User user, final ModelMap model) {
        return "views/userlogin/login";
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String checkPassword(final BindingResult BindingResult, final ModelMap model) {
        //Check het wachtwoord met behulp van de LoginService
        return "Nog verder uitwerken";
    }
    
    
}
