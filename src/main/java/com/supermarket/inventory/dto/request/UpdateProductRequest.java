package com.supermarket.inventory.dto.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateProductRequest {

    @Size(max = 150, message = "name must not exceed 150 characters")
    private String name;

    @Size(max = 500, message = "description must not exceed 500 characters")
    private String description;

    @Positive(message = "price must be greater than zero")
    private BigDecimal price;

    @Positive(message = "cost price must be greater than zero")
    private BigDecimal costPrice;

    private Long categoryId;

    private Boolean active;
}