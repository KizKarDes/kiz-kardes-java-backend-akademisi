package com.example.dressrentalapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dress")
@Getter
@Setter
public class Dress {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Otomatik artan ID

    @NotNull(message = "Dress name cannot be null")
    @Size(min = 2, max = 50, message = "Dress name must be between 2 and 50 characters")
    private String name; // Elbise adı

    @NotNull(message = "Size cannot be null")
    private String size; // Elbise bedeni

    @NotNull(message = "Price cannot be null")
    private double price; // Kiralama ücreti

    @Getter
    @Setter
    private boolean available = true; // Kiralama durumu

    // Getter ve Setter metodları

    public @NotNull(message = "Dress name cannot be null") @Size(min = 2, max = 50, message = "Dress name must be between 2 and 50 characters") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Dress name cannot be null") @Size(min = 2, max = 50, message = "Dress name must be between 2 and 50 characters") String name) {
        this.name = name;
    }


    public @NotNull(message = "Size cannot be null") String getSize() {
        return size;
    }

    public void setSize(@NotNull(message = "Size cannot be null") String size) {
        this.size = size;
    }

    @NotNull(message = "Price cannot be null")
    public double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Price cannot be null") double price) {
        this.price = price;
    }

}
