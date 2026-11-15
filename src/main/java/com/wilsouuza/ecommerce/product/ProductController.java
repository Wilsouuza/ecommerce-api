package com.wilsouuza.ecommerce.product;


import com.wilsouuza.ecommerce.product.dto.ProductRequestDTO;
import com.wilsouuza.ecommerce.product.dto.ProductResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> save(
            @Valid @RequestBody ProductRequestDTO request
    ){
        ProductResponseDTO created = productService.save(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }
}
