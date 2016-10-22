/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.presentation;

import java.util.List;
import nl.avans.facturatie.businesslogic.CustomerController;
import nl.avans.facturatie.datastorage.CustomerDAO;
import nl.avans.facturatie.domain.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tom Maljaars
 */

@Controller
class APIController {
    
    @RequestMapping("/api")
    String api(Model model) {
        model.addAttribute("classActiveApi","active");
        // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
        return "views/api/api";
    }
//    
//    @GetMapping("/api/customer/{ID}")
//    public List<Customer> findCostumer(@PathVariable int ID, Model model) {
//        List<Customer> customer = CustomerDAO.findAll();
//       //model.addAttribute("owner", customer);
//       return List<Customer>;
//    }
//    
//    @RequestMapping(value = "/customers", method = RequestMethod.GET)
//    public String listCustomers(Model model) {
//        logger.debug("listCustomers");
//        // Zet de opgevraagde members in het model
//        model.addAttribute("customers", CustomersService.findAllMembers());
//        // Open de juiste view template als resultaat.
//        return "views/member/list";
//    }

    
//    @RequestMapping("/api/customer/all")
//    public List getAllCustomers(@RequestParam(value="name", defaultValue="Null") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
//    }
    
//    @RequestMapping
//    public List<Customer> getAllCustomers {
//        return Customer.getAllCustomers();
//    }
    
}



