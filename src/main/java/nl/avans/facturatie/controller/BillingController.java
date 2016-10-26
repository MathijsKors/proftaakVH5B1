/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import nl.avans.facturatie.model.Billing;

/**
 *
 * @author Tom Maljaars
 */

@Controller
public class BillingController {
	
	private Billing billing;
	
	
    
    @RequestMapping("billing")
    String billing(Model model) {
        
        // Zet een 'flag' om in Bootstrap header nav het actieve menu item te vinden.
        
        model.addAttribute("classActiveBilling","active");
        return "views/billing/billing";
    }
    
}