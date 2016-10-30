package nl.avans.facturatie.service;

import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import nl.avans.facturatie.repository.InsuranceRepository;
import nl.avans.facturatie.model.Insurance;

/**
 *
 * @author Bram Mathijssen
 */

@Service
public class InsuranceService {
    
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);;
    
    private InsuranceRepository insuranceRepository;
    private Insurance insurance;
        
    @Autowired
    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public Insurance create(Insurance insurance) {
        logger.info("create - new insurance = " + insurance.getType());

        // Maak de insurance aan via de repository
        Insurance newInsurance = insuranceRepository.create(insurance);
        return newInsurance;
    }
    
    public Insurance edit(Insurance insurance, int id) {
        logger.info("edit - insurance = " + insurance.getType());

        // Maak de insurance aan via de repository
        Insurance editedinsurance = insuranceRepository.edit(insurance,id);
        return editedinsurance;
    }


    public void delete(int id) {
        logger.info("delete - insurance = " + id);
       this.insuranceRepository.deleteInsuranceById(id);
    }

    public Insurance findInsuranceById(int id) {
        logger.info("findInsuranceById - insurance = " + id);
        Insurance result = insuranceRepository.findInsuranceById(id);
        return result;
    }

    public List<Insurance> findAllInsurances() {
        logger.info("findAllInsurances");
        return insuranceRepository.findAll();
    }

}
