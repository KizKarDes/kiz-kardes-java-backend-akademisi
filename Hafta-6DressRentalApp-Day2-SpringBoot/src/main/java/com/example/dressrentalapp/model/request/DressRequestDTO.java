package com.example.dressrentalapp.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Elbise için DTO sınıfı, id içermiyor
@Getter
@Setter
public class DressRequestDTO {

    @NotNull(message = "Dress name cannot be null")
    @Size(min = 2, max = 50, message = "Dress name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Size cannot be null")
    private String size;

    @NotNull(message = "Price cannot be null")
    private double price;

}
