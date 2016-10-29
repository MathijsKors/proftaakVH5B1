package nl.avans.facturatie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;
import nl.avans.facturatie.model.Insurance;
import nl.avans.facturatie.service.InsuranceService;
import nl.avans.facturatie.model.Customer;
import nl.avans.facturatie.service.CustomerService;

/**
 *
 * @author Bram Mathijssen
 */
public class CustomerInsuranceController {
    
}
