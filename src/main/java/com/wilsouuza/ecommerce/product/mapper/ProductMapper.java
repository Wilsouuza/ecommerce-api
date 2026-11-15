package com.wilsouuza.ecommerce.product.mapper;

import com.wilsouuza.ecommerce.category.Category;
import com.wilsouuza.ecommerce.product.Product;
import com.wilsouuza.ecommerce.product.dto.ProductRequestDTO;
import com.wilsouuza.ecommerce.product.dto.ProductResponseDTO;

public class ProductMapper {

    public static ProductResponseDTO toResponseDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getBrand(),
                product.getCategory().getName()
        );
    }

    public static Product toEntity(ProductRequestDTO request, Category category) {
        return new Product(
                request.name(),
                request.description(),
                request.price(),
                request.sku(),
                request.brand(),
                category
        );
    }
}