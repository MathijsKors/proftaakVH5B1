package nl.avans.facturatie.controller;

import nl.avans.facturatie.model.User;
import nl.avans.facturatie.service.TreatmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
        

@Controller
@SessionAttributes (value = "user", types = {User.class} )
class HomeController {
    
    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }
    
    
    TreatmentService treatmentService;

    @RequestMapping("/")
    String index(@ModelAttribute("user") User user, Model model) {
        if (!user.isAuthenticated() ) {
            return "redirect:/login";
        }
        // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
        model.addAttribute("classActiveHome","active");
        return "views/home/index";

    }
    
    @RequestMapping("/behandelingen")
    String treatments(Model model) {
        model.addAttribute("treatments", treatmentService.getSettedTreatments());
        return "views/home/treatments";

    }
    
    @RequestMapping("/api")
    String api(Model model) {
        model.addAttribute("classActiveApi","active");
        // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
        return "views/api/api";
    }
    
    


    
}
