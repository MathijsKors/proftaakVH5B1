package nl.avans.facturatie.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.avans.facturatie.model.Billing;
import nl.avans.facturatie.repository.BillingRepository;

@Service
public class BillingService {

    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);;

    private BillingRepository billingRepository;

    @Autowired
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public Billing create(Billing billing) {
        logger.info("create - new billing = " + billing.getBillingID());

        // Maak de billing aan via de repository
        Billing newBilling = billingRepository.create(billing);
        return newBilling;
    }

    public void delete(int id) {
        logger.info("delete - billing = " + id);
        this.billingRepository.findBillingById(id);
    }

    public Billing findBillingById(int id) {
        logger.info("findBillingById - billing = " + id);
        Billing result = billingRepository.findBillingById(id);
        return result;
    }

    public List<Billing> findAllBillings() {
        logger.info("findAllBillings");
        return billingRepository.findAll();
    }
}
