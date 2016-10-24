/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import nl.avans.facturatie.repository.CustomerRepository;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.any;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.any;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tom
 */
public class UniqueBSNValidator implements ConstraintValidator<UniqueBSN, String>{
    
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void initialize(UniqueBSN a) {
    }

    @Override
    public boolean isValid(String bsn, ConstraintValidatorContext cvc) {
        return customerRepository.findCustomerByBSN(bsn);
    }

  
}