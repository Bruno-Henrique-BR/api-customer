package com.apicustomer.tgroup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    private Integer number;
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

    public Address(String zipCode, String street, Integer number, String complement, String district, String city, String state, String country) {
        this.zipCode = zipCode;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
