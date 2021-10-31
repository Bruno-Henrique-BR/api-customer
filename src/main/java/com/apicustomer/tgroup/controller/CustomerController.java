package com.apicustomer.tgroup.controller;

import com.apicustomer.tgroup.model.Customer;
import com.apicustomer.tgroup.repository.CustomerRepository;
import com.apicustomer.tgroup.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @ApiOperation(value = "Retorna uma lista de Customers")
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> customer(){
        List<Customer> customers = customerService.listaCustomer();
        return ResponseEntity.ok(customers);
    }

    @ApiOperation(value = "Consulta um customer")
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> customer(@PathVariable Long id){
        return customerService.getByCustomer(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Cria um customer")
    @PostMapping("/customer")
    public ResponseEntity<Customer> create(@RequestBody @Valid Customer customer) {
        customer = customerService.createCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Atualiza um customer")
    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody @Valid Customer customer) {
        customer = customerService.updateCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Deleta um customer")
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id) {
        customerService.deletarCustomer(id);
        return ResponseEntity.noContent().build();
    }





}
