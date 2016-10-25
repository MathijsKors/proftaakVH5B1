package nl.avans.facturatie.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.avans.facturatie.model.InsuranceCompany;
import nl.avans.facturatie.repository.InsuranceCompanyRepository;

@Service
public class InsuranceCompanyService {

    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);;

    private InsuranceCompanyRepository insuranceCompanyRepository;

    @Autowired
    public InsuranceCompanyService(InsuranceCompanyRepository insuranceCompanyRepository) {
        this.insuranceCompanyRepository = insuranceCompanyRepository;
    }

    public InsuranceCompany create(InsuranceCompany insuranceCompany) {
        logger.info("create - new insuranceCompany = " + insuranceCompany.getName());

        // Maak de customer aan via de repository
        InsuranceCompany newInsuranceCompany = insuranceCompanyRepository.create(insuranceCompany);
        return newInsuranceCompany;
    }

    public void delete(int id) {
        logger.info("delete - insuranceCompany = " + id);
        this.insuranceCompanyRepository.deleteInsuranceCompanyById(id);
    }

    public InsuranceCompany findInsuranceCompanyById(int id) {
        logger.info("findInsuranceCompanyById - insurancecompany = " + id);
        InsuranceCompany result = insuranceCompanyRepository.findInsuranceCompanyById(id);
        return result;
    }

    public List<InsuranceCompany> findAllInsuranceCompanies() {
        logger.info("findAllInsuranceCompanies");
        return insuranceCompanyRepository.findAll();
    }
}
