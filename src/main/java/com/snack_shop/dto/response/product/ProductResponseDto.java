package com.snack_shop.dto.response.product;

import com.snack_shop.enums.ProductStatus;

public class ProductResponseDto {
    private int id;
    private String productName;
    private int cateogryId;
    private String description;
    private String imageLink;
    private double price;
    private ProductStatus status;
    private int typeId;

    public ProductResponseDto() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCateogryId() {
        return cateogryId;
    }

    public void setCateogryId(int cateogryId) {
        this.cateogryId = cateogryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
