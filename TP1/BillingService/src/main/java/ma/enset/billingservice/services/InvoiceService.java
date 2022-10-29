package ma.enset.billingservice.services;

import ma.enset.billingservice.dto.InvoiceRequestDTO;
import ma.enset.billingservice.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(String invoiceId);
    List<InvoiceResponseDTO> invoicesByCustomerId(String customerId);

    List<InvoiceResponseDTO> allInvoices();
}
