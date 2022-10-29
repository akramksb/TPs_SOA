package ma.enset.billingservice;

import ma.enset.billingservice.dto.InvoiceRequestDTO;
import ma.enset.billingservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InvoiceService invoiceService){
        return args -> {
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(87000),"123akram"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(57000),"123saad"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(61000),"123yasin"));
        };
    }


}
