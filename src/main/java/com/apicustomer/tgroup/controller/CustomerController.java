package com.apicustomer.tgroup.controller;

import com.apicustomer.tgroup.model.Customer;
import com.apicustomer.tgroup.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> listaCustomer(){
        return customerRepository.findAll();
    }


    @GetMapping("/customer/{id}")
    public Customer GetPessoaById(@PathVariable(value="id") long id){
        return customerRepository.findById(id);
    }


    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody @Valid Customer customer) {
        return customerRepository.save(customer);
    }


    @DeleteMapping("/customer/{id}")
    public Customer deleteCustomer(@PathVariable(value="id") long id){
        return customerRepository.deleteById(id);
    }


    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody @Valid Customer customer) {
        return customerRepository.save(customer);
    }
}
