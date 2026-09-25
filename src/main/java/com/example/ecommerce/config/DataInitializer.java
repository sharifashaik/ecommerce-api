package com.example.ecommerce.config;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.Role;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Seed admin user
        if (!userRepository.existsByEmail("admin@example.com")) {
            userRepository.save(User.builder()
                    .fullName("Admin User")
                    .email("admin@example.com")
                    .password(passwordEncoder.encode("admin123"))
                    .roles(Set.of(Role.ROLE_ADMIN, Role.ROLE_USER))
                    .build());
        }

        // Seed normal user
        if (!userRepository.existsByEmail("user@example.com")) {
            userRepository.save(User.builder()
                    .fullName("Normal User")
                    .email("user@example.com")
                    .password(passwordEncoder.encode("user123"))
                    .roles(Set.of(Role.ROLE_USER))
                    .build());
        }

        // Seed sample products
        if (productRepository.count() == 0) {
            productRepository.save(Product.builder()
                    .name("iPhone 15").description("Apple flagship")
                    .price(new BigDecimal("999.00")).stockQuantity(25)
                    .category("Electronics").build());
            productRepository.save(Product.builder()
                    .name("Samsung Galaxy S24").description("Android flagship")
                    .price(new BigDecimal("899.00")).stockQuantity(30)
                    .category("Electronics").build());
            productRepository.save(Product.builder()
                    .name("Sony WH-1000XM5").description("Noise-cancelling headphones")
                    .price(new BigDecimal("349.00")).stockQuantity(50)
                    .category("Audio").build());
        }
    }
}