package com.example.dressrentalapp.controller;

import com.example.dressrentalapp.model.User;
import com.example.dressrentalapp.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void getAllUsers_ReturnsUserList() throws Exception {
        // given
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setId(1L);
        user1.setEmail("user1@example.com");
        User user2 = new User();
        user2.setId(2L);
        user2.setEmail("user2@example.com");
        users.add(user1);
        users.add(user2);

        when(userService.getAllUsers()).thenReturn(users);

        // when & then
        mockMvc.perform(get("/api/users/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].email").value("user1@example.com"))
                .andExpect(jsonPath("$[1].email").value("user2@example.com"));
    }

    @Test
    void getUserById_ReturnsUser() throws Exception {
        // given
        User user = new User();
        user.setId(1L);
        user.setEmail("user1@example.com");

        when(userService.getUserById(1L)).thenReturn(user);

        // when & then
        mockMvc.perform(get("/api/users/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.email").value("user1@example.com"));
    }
}
