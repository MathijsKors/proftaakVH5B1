/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bram
 */
@Controller
class SettingsController {

    @RequestMapping("/settings")
    String insurancecompany(Model model) {
        model.addAttribute("settings");

        // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
        
        model.addAttribute("classActiveSettings","active");
        return "views/settings/settings";
        
        
    }

    
}
