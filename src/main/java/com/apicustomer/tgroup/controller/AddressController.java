package com.apicustomer.tgroup.controller;

import com.apicustomer.tgroup.model.Address;
import com.apicustomer.tgroup.model.Customer;
import com.apicustomer.tgroup.repository.AddressRepository;
import com.apicustomer.tgroup.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CustomerRepository customerRepository;


    @GetMapping("/{id}")
    public List<Customer> listaAddress(@PathVariable(value="id") long id){
        return customerRepository.findAllById(Collections.singleton(id));
    }

    @GetMapping("/addressByCustomer/{id}")
    public Collection<Address> GetAddressByCustomer(@PathVariable(value="id") long id){
        return addressRepository.getByAddressesCustomer(id);
    }

    @GetMapping("/address/{id}")
    public Address GetAddressId(@PathVariable(value="id") long id){
        return addressRepository.findById(id);
    }

    @PostMapping("/address")
    public Address createAddress(@RequestBody @Valid Address address) {
        return addressRepository.save(address);
    }
    @DeleteMapping("/address/{id}")
    public Address deleteAddress(@PathVariable(value="id") long id){
        return addressRepository.deleteById(id);
    }
}
