package com.wilsouuza.ecommerce.product;


import com.wilsouuza.ecommerce.category.Category;
import com.wilsouuza.ecommerce.category.CategoryRepository;
import com.wilsouuza.ecommerce.exception.DuplicateResourceException;
import com.wilsouuza.ecommerce.exception.ResourceNotFoundException;
import com.wilsouuza.ecommerce.product.dto.ProductRequestDTO;
import com.wilsouuza.ecommerce.product.dto.ProductResponseDTO;
import com.wilsouuza.ecommerce.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Transactional
    public ProductResponseDTO save(ProductRequestDTO request) {

        if(productRepository.existsBySku(request.sku())){
            throw new DuplicateResourceException("Product SKU already exists");
        }

        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(()->
                        new ResourceNotFoundException("Category not found with ID: " + request.categoryId()));

        Product newProduct = ProductMapper.toEntity(request,category);

        Product savedProduct = productRepository.save(newProduct);

        return ProductMapper.toResponseDTO(savedProduct);
    }

    @Transactional(readOnly = true)
    public List<ProductResponseDTO> findAll(){
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponseDTO)
                .toList();
    }


}
