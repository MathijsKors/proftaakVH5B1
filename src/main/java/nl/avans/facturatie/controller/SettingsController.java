/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.controller;


import nl.avans.facturatie.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Bram
 */
@Controller
@SessionAttributes (value = "user", types = {User.class} )
class SettingsController {

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }    
    
    @RequestMapping("/settings")
    String insurancecompany(@ModelAttribute("user") User user, Model model) {
        if (!user.isAuthenticated() ) {
            return "redirect:/login";
        }        
        
        model.addAttribute("settings");

        // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
        
        model.addAttribute("classActiveSettings","active");
        return "views/settings/settings";
        
        
    }

    
}
