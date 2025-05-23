package com.example.dressrentalapp.controller;

import com.example.dressrentalapp.model.Cart;
import com.example.dressrentalapp.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class CartControllerTest {

    @Mock
    private CartService cartService;

    @InjectMocks
    private CartController cartController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(cartController).build();
    }

    @Test
    void viewCart_ReturnsCart() throws Exception {
        // given
        Cart cart = new Cart();
        cart.setTotalPrice(0);
        when(cartService.getCart(1L)).thenReturn(cart);

        // when & then
        mockMvc.perform(get("/api/carts/{userId}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void addToCart_CallsAddToCartService() throws Exception {
        // given

        // when & then
        mockMvc.perform(post("/api/carts/{userId}/add/{dressId}", 1L, 1L))
                .andExpect(status().isOk());

        verify(cartService).addToCart(1L, 1L);
    }

    @Test
    void removeFromCart_CallsRemoveFromCartService() throws Exception {
        // given

        // when & then
        mockMvc.perform(delete("/api/carts/{userId}/remove/{dressId}", 1L, 1L))
                .andExpect(status().isOk());

        verify(cartService).removeFromCart(1L, 1L);
    }
}
