/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class LoginController {

    @RequestMapping("login")
    String index(Model model) {

        // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
        
        model.addAttribute("classActiveLogin","active");
        return "views/home/login";
        
        
    }

    
}
