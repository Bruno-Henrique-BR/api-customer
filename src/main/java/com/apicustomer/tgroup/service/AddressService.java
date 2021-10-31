package com.apicustomer.tgroup.service;

import com.apicustomer.tgroup.model.Address;
import com.apicustomer.tgroup.model.Customer;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<Customer> listaAddress(Long id);
    Collection<Address> GetAddressByCustomer(Long id);
    Optional<Address> getByAddress(Long id);
    Address createAddress(Address address);
    Address updateAddress(Address address);
    void deletarAddress(Long id);
}
