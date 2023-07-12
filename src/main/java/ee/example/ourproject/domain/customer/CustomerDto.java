package ee.example.ourproject.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {

    private String firstName;
    private String lastName;

}
