package ma.enset.billingservice.web;

import lombok.AllArgsConstructor;
import ma.enset.billingservice.dto.InvoiceRequestDTO;
import ma.enset.billingservice.dto.InvoiceResponseDTO;
import ma.enset.billingservice.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class InvoiceRestController {
    private InvoiceService invoiceService;

    @GetMapping("/invoices")
    public List<InvoiceResponseDTO> all(){
        return invoiceService.allInvoices();
    }

    @GetMapping("/invoices/{id}")
    public InvoiceResponseDTO getInvoice(
            @PathVariable(name = "id") String invoiceId){
        return invoiceService.getInvoice(invoiceId);
    }

    @GetMapping("/invoices/customer/{customerId}")
    public List<InvoiceResponseDTO> getInvoicesByCustomerId(@PathVariable String customerId){
        return invoiceService.invoicesByCustomerId(customerId);
    }

    @PostMapping("/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.save(invoiceRequestDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
