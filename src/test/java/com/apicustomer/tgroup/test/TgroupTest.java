package com.apicustomer.tgroup.test;


import com.apicustomer.tgroup.model.Address;
import com.apicustomer.tgroup.repository.AddressRepository;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TgroupTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private AddressRepository addressRepository;

    private Address address;


    private String zipCode = "Bruno";

    private String street = "Bruno Henrique";

    private Integer number = 10;

    private String complement = "Bruno Henrique";

    private String district = "Bruno Henrique";

    private String city = "Bruno Henrique";

    private String state = "Bruno Henrique";

    private String country = "Bruno Henrique";

    @Before
    public void start() {
        address = new Address(zipCode, street, number, complement, district, city, state, country);
        addressRepository.save(address);
    }

    @After
    public void end() {
        addressRepository.deleteAll();
    }
    @Test
    public void alterarDeveAlterarContatoComPut() {
        address.setCity("Bruno Henrique");
        testRestTemplate.put("/address/{id}",address,address.getId());

        Address resultado = addressRepository.findById(address.getId()).get();
        Assert.assertEquals(zipCode, resultado.getZipCode());
        Assert.assertEquals(complement, resultado.getComplement());
        Assert.assertEquals(street, resultado.getStreet());
        Assert.assertEquals(number, resultado.getNumber());
        Assert.assertEquals(district, resultado.getDistrict());
        Assert.assertEquals(state, resultado.getState());
        Assert.assertEquals(country, resultado.getCountry());

        Assert.assertEquals("Bruno Henrique", resultado.getCity());
    }

    @Test
    public void removerDeveExcluirContato() {
        ResponseEntity<Address> resposta =
                testRestTemplate.exchange("/api/address/{id}",HttpMethod.DELETE,null
                        , Address.class,address.getId());

        Assert.assertEquals(HttpStatus.NO_CONTENT,resposta.getStatusCode());
        Assert.assertNull(resposta.getBody());
    }

    @Test
    public void removerDeveExcluirContatoComDelete() {
        testRestTemplate.delete("/api/address/"+address.getId());

        Optional<Address> resultado = addressRepository.findById(address.getId());
        Assert.assertEquals(Optional.empty(), resultado);
    }
}
