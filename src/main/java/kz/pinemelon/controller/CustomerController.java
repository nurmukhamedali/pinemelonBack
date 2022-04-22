package kz.pinemelon.controller;

import kz.pinemelon.entities.Customer;
import kz.pinemelon.entities.Views;
import kz.pinemelon.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@CrossOrigin(origins="http://localhost:8080")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    List<Customer> getAll() {
        return customerService.listCustomer();
    }

    @GetMapping("{id}")
    public Customer get(
            @PathVariable("id") Customer customer){
        return customer;
    }

    @PostMapping
    public Customer create(
            @RequestBody Customer customer
    ) {
        return customerService.create(customer);
    }

    @PutMapping("{id}")
    public Customer update(
            @PathVariable("id") Customer customerFromDB,
            @RequestBody Customer customer
    ){
        return customerService.update(customerFromDB, customer);
    }

    @DeleteMapping("{id}")
    public void delete(
            @PathVariable("id") Customer customer){
        customerService.delete(customer);
    }


}
