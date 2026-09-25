package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductRequest;
import com.example.ecommerce.dto.ProductResponse;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<ProductResponse> list(int page, int size, String category, String search) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Product> result;

        if (search != null && !search.isBlank()) {
            result = productRepository.findByNameContainingIgnoreCase(search, pageable);
        } else if (category != null && !category.isBlank()) {
            result = productRepository.findByCategoryIgnoreCase(category, pageable);
        } else {
            result = productRepository.findAll(pageable);
        }
        return result.map(ProductResponse::from);
    }

    public ProductResponse get(Long id) {
        return ProductResponse.from(find(id));
    }

    @Transactional
    public ProductResponse create(ProductRequest req) {
        Product p = Product.builder()
                .name(req.getName())
                .description(req.getDescription())
                .price(req.getPrice())
                .stockQuantity(req.getStockQuantity())
                .category(req.getCategory())
                .build();
        return ProductResponse.from(productRepository.save(p));
    }

    @Transactional
    public ProductResponse update(Long id, ProductRequest req) {
        Product p = find(id);
        p.setName(req.getName());
        p.setDescription(req.getDescription());
        p.setPrice(req.getPrice());
        p.setStockQuantity(req.getStockQuantity());
        p.setCategory(req.getCategory());
        return ProductResponse.from(productRepository.save(p));
    }

    @Transactional
    public void delete(Long id) {
        Product p = find(id);
        productRepository.delete(p);
    }

    private Product find(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found: " + id));
    }
}