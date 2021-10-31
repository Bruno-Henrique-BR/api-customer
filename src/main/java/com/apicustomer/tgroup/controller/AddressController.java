package com.apicustomer.tgroup.controller;

import com.apicustomer.tgroup.model.Address;
import com.apicustomer.tgroup.model.Customer;
import com.apicustomer.tgroup.repository.AddressRepository;
import com.apicustomer.tgroup.repository.CustomerRepository;
import com.apicustomer.tgroup.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Customers")
public class AddressController {

    @Autowired
    AddressService addressService;

    @ApiOperation(value = "Retorna uma lista de addresses")
    @GetMapping("/{id}")
    public ResponseEntity<List<Customer>> customers(Long id){
        List<Customer> customers = addressService.listaAddress(id);
        return ResponseEntity.ok(customers);
    }

    @ApiOperation(value = "Retorna a lista de Address do Customer ")
    @GetMapping("/addressByCustomer/{id}")
    public ResponseEntity<Collection<Address>> listaAddress(Long id){
        Collection<Address> addresses = addressService.GetAddressByCustomer(id);
        return ResponseEntity.ok(addresses);
    }

    @ApiOperation(value = "Consulta um address")
    @GetMapping("/address/{id}")
    public ResponseEntity<Address> consultaAddress(@PathVariable Long id){
        return addressService.getByAddress(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Cria um address")
    @PostMapping("/address")
    public ResponseEntity<Address> create(@RequestBody @Valid Address address) {
        address = addressService.createAddress(address);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Atualiza um address")
    @PutMapping("/address/{id}")
    public ResponseEntity<Address> update(@PathVariable Long id, @RequestBody @Valid Address address) {
        address = addressService.updateAddress(address);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Deleta um address")
    @DeleteMapping("/address/{id}")
    public ResponseEntity<Address> delete(@PathVariable Long id) {
        addressService.deletarAddress(id);
        return ResponseEntity.noContent().build();
    }
}
