/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.presentation;

import nl.avans.facturatie.businesslogic.CustomerController;
import nl.avans.facturatie.domain.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    @RequestMapping(value={"/api/customer/{ID}"})
    @ResponseBody
    public Customer costumer(@RequestParam(value="ID") int ID) {
        return costumer(ID);
    }
    
    @GetMapping("//api/customer/{ID}")
    public String findCostumer(@PathVariable String ID, Model model) {
       //Customer customer = CustomerController.findCustomer(ID);
        //model.addAttribute("owner", customer);
        return "displayOwner";
    }
    
//    @RequestMapping(value={"/api/customer/all"})
//    @ResponseBody
//    public List<Customer> costumer(Customer) {
//        return Customer.getAllCustomers();
//    }
    
}



