package com.veluz.model.dto;

public class AuthResponse {
    private String message;
    private Integer userId;
    private String username;
    private String role;

    public AuthResponse() {}

    public AuthResponse(String message, Integer userId, String username, String role) {
        this.message = message;
        this.userId = userId;
        this.username = username;
        this.role = role;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
