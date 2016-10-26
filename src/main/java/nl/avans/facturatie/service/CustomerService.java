package nl.avans.facturatie.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import nl.avans.facturatie.repository.CustomerRepository;
import nl.avans.facturatie.model.Customer;

/**
 *
 * @author Gebruiker
 */
@Service
public class CustomerService {

    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);;

    private final CustomerRepository customerRepository;
    private Customer customer;

    /**
     *
     * @param customerRepository
     */
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     *
     * @param customer
     * @return
     */
    public Customer create(Customer customer) {
        logger.info("create - new customer = " + customer.getFullName());

        // Maak de customer aan via de repository
        Customer newCustomer = customerRepository.create(customer);
        return newCustomer;
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
        Customer editedcustomer = customerRepository.edit(customer,id);
        return editedcustomer;
    }

    /**
     *
     * @param id
     */
    public void delete(int id) {
        logger.info("delete - customer = " + id);
        this.customerRepository.deleteCustomerById(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public Customer findCustomerById(int id) {
        logger.info("findCustomerById - customer = " + id);
        Customer result = customerRepository.findCustomerById(id);
        return result;
    }
    
    /**
     *
     * @param bsnNumber
     * @return
     */
    public int findCustomerByBSN(String bsnNumber){
        logger.info("findCustomerByBSN - BSN = " + bsnNumber);
        int result = customerRepository.findcustomerByBSN(bsnNumber);
        return result;
    }

    /**
     *
     * @return
     */
    public List<Customer> findAllCustomers() {
        logger.info("findAllCustomers");
        return customerRepository.findAll();
    }

}
