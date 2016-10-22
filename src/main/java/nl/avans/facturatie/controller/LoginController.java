package nl.avans.facturatie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class LoginController {

    @RequestMapping("/login")
    String login(Model model) {

        // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
        
        model.addAttribute("classActiveLogin","active");
        return "views/userlogin/login";
        
        
    }

    
}
