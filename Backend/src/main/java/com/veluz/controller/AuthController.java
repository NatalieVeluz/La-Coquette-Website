package com.veluz.controller;

import com.veluz.entity.Customer;
import com.veluz.model.dto.LoginRequest;
import com.veluz.model.dto.SignupRequest;
import com.veluz.model.dto.AuthResponse;
import com.veluz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200") // allow Angular frontend
public class AuthController {

    private final CustomerService customerService;

    @Autowired
    public AuthController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // SIGNUP — create a new customer account
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest signupRequest) {
        Customer customer = customerService.registerCustomer(signupRequest);
        AuthResponse response = new AuthResponse(
                "Customer registered successfully",
                customer.getId(),
                customer.getUsername(),
                "CUSTOMER"
        );
        return ResponseEntity.ok(response);
    }

    // LOGIN — validate credentials
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        Customer customer = customerService.login(loginRequest);
        AuthResponse response = new AuthResponse(
                "Login successful",
                customer.getId(),
                customer.getUsername(),
                "CUSTOMER"
        );
        return ResponseEntity.ok(response);
    }

    // LOGOUT — session cleanup only (NO database deletion)
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // This does nothing in the database. It's here just for the frontend call.
        return ResponseEntity.ok("Logout successful — session cleared.");
    }
}
