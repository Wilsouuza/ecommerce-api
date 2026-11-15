package com.wilsouuza.ecommerce.product.dto;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        String name,
        String description,
        BigDecimal price,
        String brand,
        String categoryName
) {
}
