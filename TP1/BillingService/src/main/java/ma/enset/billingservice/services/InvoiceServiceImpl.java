package ma.enset.billingservice.services;

import ma.enset.billingservice.dto.InvoiceRequestDTO;
import ma.enset.billingservice.dto.InvoiceResponseDTO;
import ma.enset.billingservice.entities.Customer;
import ma.enset.billingservice.entities.Invoice;
import ma.enset.billingservice.mappers.InvoiceMapper;
import ma.enset.billingservice.openfeign.CustomerRestClient;
import ma.enset.billingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        //TODO: check if customer exist
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(savedInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomerId(String customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerID(customerId);
        for ( Invoice invoice : invoices ){
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
            invoice.setCustomer(customer);
        }
        return invoices.stream()
                .map(invoiceMapper::fromInvoice)
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        for ( Invoice invoice : invoices ){
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
            invoice.setCustomer(customer);
        }
        return invoices.stream()
                .map(invoiceMapper::fromInvoice)
                .collect(Collectors.toList());
    }
}
