package nl.avans.facturatie.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.avans.facturatie.model.Invoice;
import nl.avans.facturatie.repository.InvoiceRepository;

@Service
public class InvoiceService {

    private final Logger logger = LoggerFactory.getLogger(InvoiceService.class);;

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice create(Invoice invoice) {
        logger.info("create - new invoice = " + invoice.getInvoiceID());

        // Maak de invoice aan via de repository
        Invoice newInvoice = invoiceRepository.create(invoice);
        return newInvoice;
    }

    public void delete(int id) {
        logger.info("delete - invoice = " + id);
        this.invoiceRepository.findInvoiceById(id);
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
