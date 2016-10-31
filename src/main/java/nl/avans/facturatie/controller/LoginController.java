package nl.avans.facturatie.controller;

import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Gebruiker
 */
@Controller
@SessionAttributes (value = "user", types = {User.class} )
public class LoginController {
    
    private LoginService loginservice;
    private User user;
    
    /**
     *
     * @param loginservice
     */
    @Autowired
    public LoginController(LoginService loginservice){
        this.loginservice = loginservice;
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
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginForm(final User user, final ModelMap model) {
        return "views/userlogin/login";
    }
    
    /**
     *
     * @param user
     * @param BindingResult
     * @param model
     * @return
     */
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String LoginUser(final User user, final BindingResult BindingResult, final ModelMap model) {
        //Check het wachtwoord met behulp van de LoginService
        if (loginservice.checkPassword(user.getUsername(), user.getPassword()) == true ){
            user.setAuthenticated(true);
            user.setPassword("");
            return "views/home/index";
        }
        else {
            model.addAttribute("info", "Onjuiste logingegevens.");
            return "redirect:/login";
        }
    }
    
    /**
     *
     * @param user
     * @return
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutUser(@ModelAttribute("user") User user) {
        user.setAuthenticated(false);
        return "redirect:/login";
    }
    
    
}    
