package com.apicustomer.tgroup.service;

import com.apicustomer.tgroup.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> listaCustomer();
    Optional<Customer> getByCustomer(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deletarCustomer(Long id);
}
