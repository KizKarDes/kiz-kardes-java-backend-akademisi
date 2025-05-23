package com.example.dressrentalapp.service;

import com.example.dressrentalapp.exception.ValidationException;
import com.example.dressrentalapp.model.User;
import com.example.dressrentalapp.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private CartService cartService;

    @InjectMocks
    private UserService userService;

    @Test
    public void addUser_UserAlreadyExists_ThrowsValidationException() {
        //Given
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password123");
        user.setRole("USER");

        when(userRepository.existsByEmail(user.getEmail())).thenReturn(true);

        //When
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            userService.addUser(user);
        });

        //Then
        assertEquals("Bu email ile kayıtlı kullanıcı bulunmaktadır.", exception.getMessage());
        verify(userRepository, never()).save(any());
        verify(cartService, never()).saveEmptyCart(any());
    }

    @Test
    public void addUser_NewUser_SavesUserAndCart() {
        //Given
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password123");
        user.setRole("USER");

        when(userRepository.existsByEmail(user.getEmail())).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(user);

        //When
        User savedUser = userService.addUser(user);

        //Then
        assertEquals(user.getEmail(), savedUser.getEmail());
        assertNotNull(savedUser.getPassword()); // Şifre hashlenmiş olmalı
        verify(userRepository).save(any(User.class));
        verify(cartService).saveEmptyCart(savedUser);
    }

    @Test
    public void getAllUsers_ReturnsUserList() {
        //Given
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password123");
        user.setRole("USER");

        when(userRepository.findAll()).thenReturn(List.of(user));

        //When
        List<User> users = userService.getAllUsers();

        //Then
        assertEquals(1, users.size());
        assertEquals(user.getEmail(), users.get(0).getEmail());
        verify(userRepository).findAll();
    }

    @Test
    public void getUserById_UserExists_ReturnsUser() {
        //Given
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password123");
        user.setRole("USER");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        //When
        User foundUser = userService.getUserById(1L);

        //Then
        assertEquals(user.getEmail(), foundUser.getEmail());
        verify(userRepository).findById(1L);
    }

    @Test
    public void getUserById_UserDoesNotExist_ThrowsException() {
        //Given
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        //When
        assertThrows(NoSuchElementException.class, () -> {
            userService.getUserById(1L);
        });

        //Then
        verify(userRepository).findById(1L);
    }

    @Test
    public void loadUserByUsername_UserExists_ReturnsUserDetails() {
        //Given
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password123");
        user.setRole("USER");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

        //When
        UserDetails userDetails = userService.loadUserByUsername(user.getEmail());

        //Then
        assertEquals(user.getEmail(), userDetails.getUsername());
        assertNotNull(userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(user.getRole())));
        verify(userRepository).findByEmail(user.getEmail());
    }

    @Test
    public void loadUserByUsername_UserDoesNotExist_ThrowsUsernameNotFoundException() {
        //Given
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password123");
        user.setRole("USER");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());

        //When
        assertThrows(UsernameNotFoundException.class, () -> {
            userService.loadUserByUsername(user.getEmail());
        });

        //Then
        verify(userRepository).findByEmail(user.getEmail());
    }
}
