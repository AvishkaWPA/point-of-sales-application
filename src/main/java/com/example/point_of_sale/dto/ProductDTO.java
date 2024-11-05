package com.example.point_of_sale.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class ProductDTO {

    private int productId;
    private String productName;

    private int availableQty;

    private double price;

    public ProductDTO(int productId, String productName, int availableQty, double price) {
        this.productId = productId;
        this.productName = productName;
        this.availableQty = availableQty;
        this.price = price;
    }

    public ProductDTO() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
