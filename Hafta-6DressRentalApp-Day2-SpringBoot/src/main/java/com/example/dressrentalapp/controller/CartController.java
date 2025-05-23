package com.example.dressrentalapp.controller;

import com.example.dressrentalapp.model.Cart;
import com.example.dressrentalapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public Cart viewCart(@PathVariable("userId") Long id) {
        return cartService.getCart(id);
    }

    @PostMapping("/{userId}/add/{dressId}")
    @ResponseStatus(HttpStatus.OK)
    public void addToCart(@PathVariable("userId") Long userId, @PathVariable("dressId") Long dressId) {
        cartService.addToCart(userId, dressId);
    }

    @DeleteMapping("/{userId}/remove/{dressId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeFromCart(@PathVariable("userId") Long userId, @PathVariable("dressId") Long dressId) {
        cartService.removeFromCart(userId, dressId);
    }
}

