package com.snack_shop.service.impl;

import com.snack_shop.dto.response.product.ProductResponseDto;
import com.snack_shop.repository.ProductRepository;
import com.snack_shop.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository = new ProductRepository();
    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public List<ProductResponseDto> getProductsByPage(int pageNumber) {
        return productRepository.getProductsByPage(pageNumber);
    }

    @Override
    public List<ProductResponseDto> getTopLatestProducts() {
        return productRepository.getTopLatestProducts();
    }

    @Override
    public ProductResponseDto getProductById(int productId) {
        return productRepository.getProductById(productId);
    }


}
