package nl.avans.facturatie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
        

@Controller
class HomeController {

    @RequestMapping("/")
    String index(Model model) {

        // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
        
        model.addAttribute("classActiveHome","active");
        return "views/home/index";
        
        
    }

    
}
