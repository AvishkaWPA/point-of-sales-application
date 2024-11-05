package com.example.point_of_sale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id",length = 45)
    private int productId;

    @Column(name = "product_name",length = 225)
    private String productName;


    @Column(name = "Quantity")
    private int availableQty;

    @Column(name = "price")
    private double price;

    public Product() {
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

    public Product(int productId, String productName, int availableQty, double price) {
        this.productId = productId;
        this.productName = productName;
        this.availableQty = availableQty;
        this.price = price;
    }

}
