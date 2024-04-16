package com.snack_shop.service;

import com.snack_shop.dto.response.product.ProductResponseDto;

import java.util.List;

public interface ProductService {
    public List<ProductResponseDto> getAllProducts();
    public ProductResponseDto getProductById(int productId);
    public List<ProductResponseDto> getProductsByPage(int pageNumber);
    public List<ProductResponseDto> getTopLatestProducts();
}
