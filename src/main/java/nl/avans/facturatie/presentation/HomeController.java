package nl.avans.facturatie.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
class HomeController {

    @RequestMapping("/")
    String index(Model model) {

        // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
        
        model.addAttribute("classActiveHome","active");
        return "views/home/index";
        
        
    }

    
}
