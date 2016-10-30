package nl.avans.facturatie.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import nl.avans.facturatie.repository.CustomerRepository;
import nl.avans.facturatie.model.Customer;
import nl.avans.facturatie.repository.CustomerInsuranceRepository;

/**
 *
 * @author Gebruiker
 */
@Service
public class CustomerInsuranceService {

    private final Logger logger = LoggerFactory.getLogger(CustomerInsuranceService.class);;

    private final CustomerInsuranceRepository customerInsuranceRepository;
    private Customer customer;

    /**
     *
     * @param customerRepository
     */
    @Autowired
    public CustomerInsuranceService(CustomerInsuranceRepository customerInsuranceRepository) {
        this.customerInsuranceRepository = customerInsuranceRepository;
    }

    
    /**
     *
     * @param customer
     * @param id
     * @return
     */
    public Customer edit(Customer customer, int id) {
        logger.info("edit - customer = " + customer.getFullName());

        // Maak de customer aan via de repository
        Customer editedcustomer = customerInsuranceRepository.edit(customer,id);
        return editedcustomer;
    }


    /**
     *
     * @param id
     * @return
     */
    public Customer findCustomerById(int id) {
        logger.info("findCustomerById - customer = " + id);
        Customer result = customerInsuranceRepository.findCustomerById(id);
        return result;
    }
    

    /**
     *
     * @return
     */
    public List<Customer> findAllCustomers() {
        logger.info("findAllCustomers");
        return customerInsuranceRepository.findAll();
    }

}