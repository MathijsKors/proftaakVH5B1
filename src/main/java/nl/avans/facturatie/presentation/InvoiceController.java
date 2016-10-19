package nl.avans.facturatie.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class InvoiceController {

    @RequestMapping("invoices")
    String index(Model model) {
        
        // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
        
        model.addAttribute("classActiveInvoice","active");
        return "views/invoice/invoices";
        
        
    }

    
}
