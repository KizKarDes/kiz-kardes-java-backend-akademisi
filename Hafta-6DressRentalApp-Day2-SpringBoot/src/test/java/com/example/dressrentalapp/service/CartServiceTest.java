package com.example.dressrentalapp.service;

import com.example.dressrentalapp.exception.ResourceNotFoundException;
import com.example.dressrentalapp.model.Cart;
import com.example.dressrentalapp.model.CartItem;
import com.example.dressrentalapp.model.Dress;
import com.example.dressrentalapp.model.User;
import com.example.dressrentalapp.repository.CartRepository;
import com.example.dressrentalapp.repository.DressRepository;
import com.example.dressrentalapp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @Mock
    private DressRepository dressRepository;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CartService cartService;

    private User user;
    private Dress dress;
    private Dress dress2;
    private Cart cart;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");

        dress = new Dress();
        dress.setId(1L);
        dress.setName("Evening Gown");
        dress.setPrice(350);

        dress2 = new Dress();
        dress2.setId(2L);
        dress2.setName("T-shirt");
        dress2.setPrice(100);


        cart = new Cart();
        cart.setUser(user);
    }

    @Test
    void saveEmptyCart_SavesCartForUser() {
        // given
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        // when
        cartService.saveEmptyCart(user);

        // then
        verify(cartRepository).save(any(Cart.class));
    }

    @Test
    void getCart_UserHasCart_ReturnsCart() {
        // given
        when(cartRepository.findByUserId(user.getId())).thenReturn(Optional.of(cart));

        // when
        Cart foundCart = cartService.getCart(user.getId());

        // then
        assertEquals(cart, foundCart);
        verify(cartRepository).findByUserId(user.getId());
    }

    @Test
    void getCart_UserHasNoCart_ThrowsResourceNotFoundException() {
        // given
        when(cartRepository.findByUserId(user.getId())).thenReturn(Optional.empty());

        // when & then
        assertThrows(ResourceNotFoundException.class, () -> {
            cartService.getCart(user.getId());
        });

        verify(cartRepository).findByUserId(user.getId());
    }

    @Test
    void addToCart_DressExists_AddsDressToCart() {
        // given
        when(dressRepository.findById(dress.getId())).thenReturn(Optional.of(dress));
        when(cartRepository.findByUserId(user.getId())).thenReturn(Optional.of(cart));
        when(cartRepository.save(cart)).thenReturn(cart);

        // when
        cartService.addToCart(user.getId(), dress.getId());

        // then
        assertEquals(1, cart.getItems().size());
        assertEquals(dress, cart.getItems().get(0).getDress());
        verify(cartRepository).save(cart);
    }

    @Test
    void addToCart_DressDoesNotExist_ThrowsResourceNotFoundException() {
        // given
        when(dressRepository.findById(dress.getId())).thenReturn(Optional.empty());

        // when & then
        assertThrows(ResourceNotFoundException.class, () -> {
            cartService.addToCart(user.getId(), dress.getId());
        });

        verify(cartRepository, never()).save(any());
    }

    @Test
    void removeFromCart_ItemExists_RemovesItemFromCart() {
        // given
        CartItem cartItem = new CartItem();
        cartItem.setDress(dress);
        cart.addItem(cartItem);
        when(cartRepository.findByUserId(user.getId())).thenReturn(Optional.of(cart));

        // when
        cartService.removeFromCart(user.getId(), dress.getId());

        // then
        assertEquals(0, cart.getItems().size());
        verify(cartRepository).save(cart);
    }

    @Test
    void removeFromCart_ItemDoesNotExist_ThrowsResourceNotFoundException() {
        // given
        when(cartRepository.findByUserId(user.getId())).thenReturn(Optional.of(cart));

        // when & then
        assertThrows(ResourceNotFoundException.class, () -> {
            cartService.removeFromCart(user.getId(), dress.getId());
        });

        verify(cartRepository, never()).save(any());
    }

    @Test
    void getTotalPrice_CartExists_ReturnsTotalPrice() {
        // given
        when(cartRepository.findByUserId(user.getId())).thenReturn(Optional.of(cart));
        cart.addItem(new CartItem(null, dress)); // Örnek fiyat
        cart.addItem(new CartItem(null, dress2)); // Örnek fiyat

        // when
        double totalPrice = cartService.getTotalPrice(user.getId());

        // then
        assertEquals(dress.getPrice() + dress2.getPrice(), totalPrice);
    }

    @Test
    void clearCart_CartExists_ClearsCart() {
        // given
        when(cartRepository.findByUserId(user.getId())).thenReturn(Optional.of(cart));
        cart.addItem(new CartItem(null, dress)); // Örnek fiyat

        // when
        cartService.clearCart(user.getId());

        // then
        assertEquals(0, cart.getItems().size());
        assertEquals(0, cart.getTotalPrice(), 0.01);
        verify(cartRepository).save(cart);
    }
}
