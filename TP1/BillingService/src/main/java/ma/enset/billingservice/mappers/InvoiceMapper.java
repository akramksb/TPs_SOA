package ma.enset.billingservice.mappers;

import ma.enset.billingservice.dto.InvoiceRequestDTO;
import ma.enset.billingservice.dto.InvoiceResponseDTO;
import ma.enset.billingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}
