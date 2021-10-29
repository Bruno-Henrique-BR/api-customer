package com.apicustomer.tgroup.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "zip_code")
    private String zipCode;
    @NotBlank
    private String street;
    @NotNull
    private Long number;
    @NotBlank
    private String complement;
    @NotBlank
    private String district;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String country;

    @ManyToOne
    private Customer customer;



}
