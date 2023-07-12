package ee.example.ourproject.domain.customer;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    public CustomerDao save(CustomerDto customerDto) {

        System.out.println("Customer " + customerDto.getLastName() + " dobavlen");
        CustomerDao customerDao = new CustomerDao();
        customerDao.setFirstName(customerDto.getFirstName());
        customerDao.setLastName(customerDto.getLastName());
        customerDao.setCreatedAt(LocalDateTime.now());

        return customerRepository.save(customerDao);
    }

    public List<CustomerDao> getAll() {

        System.out.println("Vozvrashajem vseh klientov");

        return customerRepository.findAll();
    }

    public int changeLastName(int id, String lastName) {

        return customerRepository.changeLastName(lastName, id);
    }

    public void delete(int id) {

        System.out.println("Udalit klienta s id: " + id);
        customerRepository.deleteById(id);
    }

    public CustomerDao getById(int id) {

        System.out.println("Poluchajem klienta po id: " + id);

        return customerRepository.findById(id).get();
    }
}
