package kz.pinemelon.services;

import kz.pinemelon.entities.Customer;
import kz.pinemelon.repositories.CustomerRepository;
import kz.pinemelon.repositories.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer create(Customer customer){
        customer.setCreationDate(LocalDateTime.now());
        customer.setUpdateDate(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    public List<Customer> listCustomer(){
        return customerRepository.findAll();
    }

    public Customer update(Customer customer, Customer temp){
        // refresh values of old by values of temp
        BeanUtils.copyProperties(temp, customer, "id");
        customer.setUpdateDate(LocalDateTime.now());
        return customerRepository.save(customer);
    }
    public void delete(Customer customer){
        customerRepository.delete(customer);
    }
}
