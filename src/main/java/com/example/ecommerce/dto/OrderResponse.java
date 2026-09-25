package com.example.ecommerce.dto;

import com.example.ecommerce.entity.Order;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class OrderResponse {
    private Long id;
    private String status;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;
    private List<Item> items;

    @Data @AllArgsConstructor @NoArgsConstructor @Builder
    public static class Item {
        private Long productId;
        private String productName;
        private Integer quantity;
        private BigDecimal unitPrice;
        private BigDecimal subtotal;
    }

    public static OrderResponse from(Order o) {
        return OrderResponse.builder()
                .id(o.getId())
                .status(o.getStatus().name())
                .totalAmount(o.getTotalAmount())
                .createdAt(o.getCreatedAt())
                .items(o.getItems().stream().map(i -> Item.builder()
                        .productId(i.getProduct().getId())
                        .productName(i.getProduct().getName())
                        .quantity(i.getQuantity())
                        .unitPrice(i.getUnitPrice())
                        .subtotal(i.getUnitPrice()
                                    .multiply(BigDecimal.valueOf(i.getQuantity())))
                        .build()).collect(Collectors.toList()))
                .build();
    }
}