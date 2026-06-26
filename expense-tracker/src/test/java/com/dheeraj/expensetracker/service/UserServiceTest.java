package com.dheeraj.expensetracker.service;

import com.dheeraj.expensetracker.entity.User;
import com.dheeraj.expensetracker.exception.DuplicateResourceException;
import com.dheeraj.expensetracker.exception.ResourceNotFoundException;
import com.dheeraj.expensetracker.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private UserService userService;

    @Test
    void testRegister() {

        User user = new User();
        user.setName("Dheeraj");
        user.setEmail("dheeraj@gmail.com");
        user.setPassword("12345");

        when(userRepository.findByEmail(user.getEmail()))
                .thenReturn(Optional.empty());

        when(bCryptPasswordEncoder.encode("12345"))
                .thenReturn("encodedPassword");

        User savedUser = new User();
        savedUser.setName("Dheeraj");
        savedUser.setEmail("dheeraj@gmail.com");
        savedUser.setPassword("encodedPassword");

        when(userRepository.save(any(User.class)))
                .thenReturn(savedUser);

        User response = userService.register(user);

        assertEquals("Dheeraj", response.getName());
        assertEquals("encodedPassword", response.getPassword());

        verify(userRepository).findByEmail("dheeraj@gmail.com");
        verify(bCryptPasswordEncoder).encode("12345");
        verify(userRepository).save(any(User.class));
    }
    @Test
    void testRegisterDuplicateEmail() {

        User user = new User();
        user.setEmail("dheeraj@gmail.com");

        when(userRepository.findByEmail(user.getEmail()))
                .thenReturn(Optional.of(user));

        assertThrows(DuplicateResourceException.class, () -> {
            userService.register(user);
        });

        verify(userRepository, times(1)).findByEmail(user.getEmail());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testLoginSuccess() {

        User user = new User();
        user.setEmail("abc@gmail.com");
        user.setPassword("encodedPassword");

        when(userRepository.findByEmail("abc@gmail.com"))
                .thenReturn(Optional.of(user));

        when(bCryptPasswordEncoder.matches("password123", "encodedPassword"))
                .thenReturn(true);

        when(jwtService.generateToken("abc@gmail.com"))
                .thenReturn("jwt-token");

        String token = userService.login("abc@gmail.com", "password123");

        assertEquals("jwt-token", token);

        verify(userRepository).findByEmail("abc@gmail.com");
        verify(bCryptPasswordEncoder).matches("password123", "encodedPassword");
        verify(jwtService).generateToken("abc@gmail.com");
    }
    @Test
    void testLoginInvalidPassword() {

        User user = new User();
        user.setEmail("abc@gmail.com");
        user.setPassword("encodedPassword");

        when(userRepository.findByEmail("abc@gmail.com"))
                .thenReturn(Optional.of(user));

        when(bCryptPasswordEncoder.matches("wrongPassword", "encodedPassword"))
                .thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> {
            userService.login("abc@gmail.com", "wrongPassword");
        });

        verify(userRepository).findByEmail("abc@gmail.com");
        verify(bCryptPasswordEncoder).matches("wrongPassword", "encodedPassword");
        verify(jwtService, never()).generateToken(anyString());
    }
}