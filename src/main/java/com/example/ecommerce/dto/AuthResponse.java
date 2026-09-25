package com.example.ecommerce.dto;

import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class AuthResponse {
    private String token;
    private String tokenType;
    private String email;
    private String fullName;
}