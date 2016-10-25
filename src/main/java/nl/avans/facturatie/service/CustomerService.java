package nl.avans.facturatie.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import nl.avans.facturatie.repository.CustomerRepository;
import nl.avans.facturatie.model.Customer;

@Service
public class CustomerService {

    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);;

    private CustomerRepository customerRepository;
    private Customer customer;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(Customer customer) {
        logger.info("create - new customer = " + customer.getFullName());

        // Maak de customer aan via de repository
        Customer newCustomer = customerRepository.create(customer);
        return newCustomer;
    }
    
    public Customer edit(Customer customer, int id) {
        logger.info("edit - customer = " + customer.getFullName());

        // Maak de customer aan via de repository
        Customer editedcustomer = customerRepository.edit(customer,id);
        return editedcustomer;
    }


    public void delete(int id) {
        logger.info("delete - customer = " + id);
        this.customerRepository.deleteCustomerById(id);
    }

    public Customer findCustomerById(int id) {
        logger.info("findCustomerById - customer = " + id);
        Customer result = customerRepository.findCustomerById(id);
        return result;
    }
    
    public int findCustomerByBSN(String bsnNumber){
        logger.info("findCustomerByBSN - BSN = " + bsnNumber);
        int result = customerRepository.findcustomerByBSN(bsnNumber);
        return result;
    }

    public List<Customer> findAllCustomers() {
        logger.info("findAllCustomers");
        return customerRepository.findAll();
    }

}
