package com.example.dressrentalapp.service;

import com.example.dressrentalapp.exception.ResourceNotFoundException;
import com.example.dressrentalapp.model.Cart;
import com.example.dressrentalapp.model.CartItem;
import com.example.dressrentalapp.model.Dress;
import com.example.dressrentalapp.model.User;
import com.example.dressrentalapp.repository.CartRepository;
import com.example.dressrentalapp.repository.DressRepository;
import com.example.dressrentalapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private DressRepository dressRepository;
    private CartRepository cartRepository;
    private UserRepository userRepository;

    @Autowired
    public CartService(DressRepository dressRepository, CartRepository cartRepository, UserRepository userRepository) {
        this.dressRepository = dressRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public void saveEmptyCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        cartRepository.save(cart);
    }

    public Cart getCart(Long userId) {
        return cartRepository.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("Dress not found."));
    }

    public void addToCart(Long userId, Long dressId) {
        Dress dress = dressRepository.findById(dressId).orElseThrow(() -> new ResourceNotFoundException("Dress not found."));
        Cart cart = getCart(userId);
        CartItem item = new CartItem();
        item.setDress(dress);
        cart.addItem(item);
        cartRepository.save(cart);
    }

    public void removeFromCart(Long userId, Long dressId) {
        Cart cart = getCart(userId);
        CartItem item = cart.getCartItemByDressId(dressId);
        cart.removeItem(item);
        cartRepository.save(cart);
    }

    public double getTotalPrice(Long userId) {
        Cart cart = getCart(userId);
        return cart.getTotalPrice();
    }

    public void clearCart(Long userId) {
        Cart cart = getCart(userId);
        cart.getItems().clear();
        cart.setTotalPrice(0);
        cartRepository.save(cart);
    }
}

