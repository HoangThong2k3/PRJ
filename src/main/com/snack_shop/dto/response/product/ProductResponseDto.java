package com.snack_shop.dto.response.product;

import com.snack_shop.enums.ProductStatus;
import java.util.Date;


public class ProductResponseDto {
    private String category;
    private int productID;
    private String productName;
    private String description;
    private String image;
    private Double price;
    private int quantity;
    private ProductStatus status;
    private Date importDate;

    public ProductResponseDto() {
    }

    public ProductResponseDto(String category, int productID, String productName, String description, String image, Double price, int quantity, ProductStatus status, Date importDate) {
        this.category = category;
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.importDate = importDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    @Override
    public String toString() {
        return "ProductResponseDto{" +
            "category='" + category + '\'' +
            ", productID=" + productID +
            ", productName='" + productName + '\'' +
            ", description='" + description + '\'' +
            ", image='" + image + '\'' +
            ", price=" + price +
            ", quantity=" + quantity +
            ", status=" + status +
            ", importDate=" + importDate +
            '}';
    }
}
