package com.supermarket.inventory.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductRequest {

    @NotBlank(message = "name is required")
    @Size(max = 150, message = "name must not exceed 150 characters")
    private String name;

    @NotBlank(message = "sku is required")
    @Size(max = 50, message = "sku must not exceed 50 characters")
    private String sku;

    @Size(max = 500, message = "description must not exceed 500 characters")
    private String description;

    @NotNull(message = "price is required")
    @Positive(message = "price must be greater than zero")
    private BigDecimal price;

    @NotNull(message = "cost price is required")
    @Positive(message = "cost price must be greater than zero")
    private BigDecimal costPrice;

    @NotNull(message = "categoryId is required")
    private Long categoryId;
}