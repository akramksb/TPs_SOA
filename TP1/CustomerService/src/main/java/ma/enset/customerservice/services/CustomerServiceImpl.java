package ma.enset.customerservice.services;

import lombok.AllArgsConstructor;
import ma.enset.customerservice.dto.CustomerRequestDTO;
import ma.enset.customerservice.dto.CustomerResponseDTO;
import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.mappers.CustomerMapper;
import ma.enset.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(updatedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS =
                customers.stream()
                .map( customerMapper::customerToCustomerResponseDTO )
                .collect(Collectors.toList());
        return customerResponseDTOS;
    }
}
