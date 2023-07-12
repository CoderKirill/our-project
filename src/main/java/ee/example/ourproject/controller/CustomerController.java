package ee.example.ourproject.controller;

import ee.example.ourproject.domain.customer.CustomerDao;
import ee.example.ourproject.domain.customer.CustomerDto;
import ee.example.ourproject.domain.customer.CustomerService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @PostMapping
    public CustomerDao save(@RequestBody CustomerDto customerDto) {

        return customerService.save(customerDto);
    }

    @GetMapping
    public List<CustomerDao> getAll() {

        return customerService.getAll();
    }

    @PutMapping
    public int changeLastName(@RequestParam int id, @RequestParam String lastName) {
        System.out.println("menjajem familiju na: " + lastName);

        return customerService.changeLastName(id, lastName);
    }

    @DeleteMapping
    public void delete(@RequestParam int id) {
        customerService.delete(id);
    }

    @GetMapping("/{id}")
    public CustomerDao getById(@PathVariable int id) {

        return customerService.getById(id);
    }

}
