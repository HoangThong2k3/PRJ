package com.snack_shop.dto.response.product;

import com.snack_shop.enums.ProductStatus;

public class ProductResponseDto {
    private String category;
    private int productID;
    private String productName;
    private String description;
    private Double price;
    private int quantity;
    private String image;
    private ProductStatus status;
    private int typeID;

    public ProductResponseDto() {
    }

    public ProductResponseDto(String category, int productID, String productName, String description,
                              Double price, int quantity, String image, ProductStatus status, int typeID) {
        this.category = category;
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.status = status;
        this.typeID = typeID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    @Override
    public String toString() {
        return "ProductResponseDto{" +
            "product_id=" + productID +
            ", product_name='" + productName + '\'' +
            ", description='" + description + '\'' +
            ", image='" + image + '\'' +
            ", quantity=" + quantity +
            ", price=" + price +
            ", status=" + status +
            ", category_id='" + category + '\'' +
            ", type_id=" + typeID +
            '}';
    }
}
