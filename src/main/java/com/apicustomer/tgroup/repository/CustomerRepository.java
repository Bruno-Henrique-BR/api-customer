package com.apicustomer.tgroup.repository;

import com.apicustomer.tgroup.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findById(long id);
    Customer deleteById(long id);
}
