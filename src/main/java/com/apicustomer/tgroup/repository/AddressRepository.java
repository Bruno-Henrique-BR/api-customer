package com.apicustomer.tgroup.repository;

import com.apicustomer.tgroup.model.Address;
import com.apicustomer.tgroup.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address deleteById(long id);
    Address findById(long id);

    @Query(value = "SELECT * FROM ADDRESS WHERE address.customer_id = ?1 ", nativeQuery = true)
    Collection<Address> getByAddressesCustomer(long id);

}
