package com.apicustomer.tgroup.service;

import com.apicustomer.tgroup.model.Customer;
import com.apicustomer.tgroup.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> listaCustomer() throws RuntimeException {
        return customerRepository.findAll();

    }
    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deletarCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> getByCustomer(Long id) {
        return customerRepository.findById(id);
    }
}
