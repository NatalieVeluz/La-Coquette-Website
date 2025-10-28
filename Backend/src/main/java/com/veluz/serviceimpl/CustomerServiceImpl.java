package com.veluz.serviceimpl;

import com.veluz.entity.Customer;
import com.veluz.model.dto.LoginRequest;
import com.veluz.model.dto.SignupRequest;
import com.veluz.repository.CustomerRepository;
import com.veluz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Customer registerCustomer(SignupRequest signupRequest) {
        if (customerRepository.existsByUsername(signupRequest.getUsername())) {
            throw new RuntimeException("Username is already taken!");
        }
        if (customerRepository.existsByEmail(signupRequest.getEmail())) {
            throw new RuntimeException("Email is already in use!");
        }

        Customer customer = new Customer();
        customer.setUsername(signupRequest.getUsername());
        customer.setEmail(signupRequest.getEmail());
        customer.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        customer.setName(signupRequest.getName());
        customer.setAddress(signupRequest.getAddress());
        customer.setPhone(signupRequest.getPhone());
        return customerRepository.save(customer);
    }

    @Override
    public Customer login(LoginRequest loginRequest) {
        Optional<Customer> customerOpt = customerRepository.findByUsername(loginRequest.getUsername());
        if (customerOpt.isEmpty()) throw new RuntimeException("Customer not found");

        Customer customer = customerOpt.get();
        if (!passwordEncoder.matches(loginRequest.getPassword(), customer.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return customer;
    }

    @Override
    public Optional<Customer> findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return customerRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }
}
