package com.example.point_of_sale.service.impl;


import com.example.point_of_sale.dto.ProductDTO;
import com.example.point_of_sale.entity.Product;
import com.example.point_of_sale.repo.ProductRepo;
import com.example.point_of_sale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceIMPL implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    public String saveProduct(ProductDTO productDTO){
        Product product = new Product(
                productDTO.getProductId(),
                productDTO.getProductName(),
                productDTO.getAvailableQty(),
                productDTO.getPrice()
        );
        productRepo.save(product);

        return "";

    }
}
