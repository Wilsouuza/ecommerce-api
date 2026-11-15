package com.wilsouuza.ecommerce.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRequestDTO(

        @NotBlank
        @Size(max = 250)
        String name,

        @NotBlank
        @Size(max = 700)
        String description,

        @NotNull
        @Positive
        BigDecimal price,

        @NotBlank
        @Size(max = 50)
        String sku,

        @NotBlank
        @Size(max = 100)
        String brand,

        @NotNull
        @Positive
        Long categoryId

) {}