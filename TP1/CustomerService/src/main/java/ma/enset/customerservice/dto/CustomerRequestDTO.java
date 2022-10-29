package ma.enset.customerservice.dto;

import lombok.Data;

@Data
public class CustomerRequestDTO {
    private String id;
    private String name;
    private String email;
}
