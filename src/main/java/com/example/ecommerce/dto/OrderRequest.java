package com.example.ecommerce.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    @NotEmpty @Valid
    private List<Item> items;

    @Data
    public static class Item {
        @NotNull
        private Long productId;

        @NotNull @Min(1)
        private Integer quantity;
    }
}