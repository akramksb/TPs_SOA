package ma.enset.customerservice.web;

import lombok.AllArgsConstructor;
import ma.enset.customerservice.dto.CustomerRequestDTO;
import ma.enset.customerservice.dto.CustomerResponseDTO;
import ma.enset.customerservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CustomerRestAPI {
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerResponseDTO> allCustomers(){
        return customerService.listCustomers();
    }

    @PostMapping("/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }

    @GetMapping("/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }
}
