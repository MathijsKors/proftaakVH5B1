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
    
    @RequestMapping("/api")
    String api(Model model) {
        model.addAttribute("classActiveApi","active");
        // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
        return "views/api/api";
    }
    
    


    
}
