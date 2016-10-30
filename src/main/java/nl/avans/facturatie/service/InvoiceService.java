package nl.avans.facturatie.service;

import java.util.List;
import nl.avans.facturatie.model.Billing;
import nl.avans.facturatie.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.avans.facturatie.model.Invoice;
import nl.avans.facturatie.model.Treatment;
import nl.avans.facturatie.repository.InvoiceRepository;

@Service
public class InvoiceService {

    private final Logger logger = LoggerFactory.getLogger(InvoiceService.class);;

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice create(Billing bill, Customer customer, Treatment treatment) {
        logger.info("create - new invoice = " + bill.getBillingID());

        // Maak de invoice aan via de repository
        Invoice newInvoice = invoiceRepository.create(bill, customer, treatment);
        return newInvoice;
    }

    public void delete(int id) {
        logger.info("delete - invoice = " + id);
        this.invoiceRepository.deleteInvoiceById(id);
    }

    public Invoice findInvoiceById(int id) {
        logger.info("findInvoiceById - invoice = " + id);
        Invoice result = invoiceRepository.findInvoiceById(id);
        return result;
    }

    public List<Invoice> findAllInvoices() {
        logger.info("findAllInvoices");
        return invoiceRepository.findAll();
    }
}
