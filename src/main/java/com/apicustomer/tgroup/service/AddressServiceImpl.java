package com.apicustomer.tgroup.service;

import com.apicustomer.tgroup.model.Address;
import com.apicustomer.tgroup.model.Customer;
import com.apicustomer.tgroup.repository.AddressRepository;
import com.apicustomer.tgroup.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> listaAddress(Long id) {
        return customerRepository.findAllById(Collections.singleton(id));
    }
    @Override
    public Collection<Address> GetAddressByCustomer(Long id) {
        return addressRepository.getByAddressesCustomer(id);
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deletarAddress(Long id) {
        addressRepository.deleteById(id);
    }


    @Override
    public Optional<Address> getByAddress(Long id) {
        return addressRepository.findById(id);
    }
}
