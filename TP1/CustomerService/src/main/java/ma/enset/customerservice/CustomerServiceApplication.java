package ma.enset.customerservice;

import ma.enset.customerservice.dto.CustomerRequestDTO;
import ma.enset.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            Stream.of("akram", "saad", "yasin", "tarik").forEach(c->{
                CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
                customerRequestDTO.setId("123"+c);
                customerRequestDTO.setName(c);
                customerRequestDTO.setEmail(c+"@gmail.com");
                customerService.save( customerRequestDTO );
            });

        };
    }

}
