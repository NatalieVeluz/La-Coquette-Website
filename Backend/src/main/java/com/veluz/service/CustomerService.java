package com.veluz.service;

import com.veluz.entity.Customer;
import com.veluz.model.dto.LoginRequest;
import com.veluz.model.dto.SignupRequest;
import java.util.Optional;

public interface CustomerService {
    Customer registerCustomer(SignupRequest signupRequest);
    Customer login(LoginRequest loginRequest);
    Optional<Customer> findByUsername(String username);
    Optional<Customer> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
