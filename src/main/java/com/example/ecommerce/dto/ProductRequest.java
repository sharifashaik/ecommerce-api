package com.example.ecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    @NotBlank @Size(max = 150)
    private String name;

    @Size(max = 1000)
    private String description;

    @NotNull @DecimalMin(value = "0.01")
    private BigDecimal price;

    @NotNull @Min(0)
    private Integer stockQuantity;

    @NotBlank @Size(max = 80)
    private String category;
}