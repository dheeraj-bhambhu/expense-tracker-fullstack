package com.dheeraj.expensetracker.controller;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import com.dheeraj.expensetracker.entity.User;
import com.dheeraj.expensetracker.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Expense API", description = "APIs for managing expenses")
@RestController
@RequestMapping ("/auth")
public class UserController {
    private  final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @Operation(
            summary = "Register User",
            description = "Registers a new user account."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User registered successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid user data"),
            @ApiResponse(responseCode = "409", description = "User already exists")
    })
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }
    @Operation(
            summary = "User Login",
            description = "Authenticates a user and returns a JWT token."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful"),
            @ApiResponse(responseCode = "401", description = "Invalid email or password")
    })
    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.login(user.getEmail(), user.getPassword());
    }
}
