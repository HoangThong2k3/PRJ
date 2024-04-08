package com.snack_shop.entities;

public class Product {
    private int id;
    private String product_name;
    private String description;
    private String images;
    private Double price;
    private int status;
    private String category_id;
    private int type_id;

    public Product() {
    }

    public Product(int id, String product_name, String category_id, String description, String images, Double price, int status, int type_id) {
        this.id = id;
        this.product_name = product_name;
        this.category_id = category_id;
        this.description = description;
        this.images = images;
        this.price = price;
        this.status = status;
        this.type_id = type_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", product_name='" + product_name + '\'' +
            ", category_id='" + category_id + '\'' +
            ", description='" + description + '\'' +
            ", images='" + images + '\'' +
            ", price=" + price +
            ", status=" + status +
            ", type_id=" + type_id +
            '}';
    }
}
