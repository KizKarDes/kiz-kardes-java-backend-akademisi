package com.example.dressrentalapp.model;

import com.example.dressrentalapp.exception.ResourceNotFoundException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
    private List<CartItem> items = new ArrayList<>();

    private double totalPrice;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public void addItem(CartItem item) {
        items.add(item);
        totalPrice += item.getDress().getPrice();
    }

    public void removeItem(CartItem item) {
        items.remove(item);
        totalPrice -= item.getDress().getPrice();
    }

    public CartItem getCartItemByDressId(Long dressId) {
        return items
                .stream()
                .filter(item ->
                        item.getDress().getId().equals(dressId)
                ).findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Item not found."));
    }

}

