package com.apicustomer.tgroup.controller;

import com.apicustomer.tgroup.model.Customer;
import com.apicustomer.tgroup.repository.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Customers")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @ApiOperation(value = "Retorna uma lista de Customers")
    @GetMapping("/customers")
    public List<Customer> listaCustomer() {
        return customerRepository.findAll();
    }

    @ApiOperation(value = "Consulta um customer")
    @GetMapping("/customer/{id}")
    public Customer GetPessoaById(@PathVariable(value = "id") long id) {
        return customerRepository.findById(id);
    }

    @ApiOperation(value = "Cria um customer")
    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody @Valid Customer customer) {
        return customerRepository.save(customer);
    }

    @ApiOperation(value = "Deleta um customer")
    @DeleteMapping("/customer/{id}")
    public Customer deleteCustomer(@PathVariable(value = "id") long id) {
        return customerRepository.deleteById(id);
    }

    @ApiOperation(value = "Atualiza um customer")
    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody @Valid Customer customer) {
        return customerRepository.save(customer);
    }

}
