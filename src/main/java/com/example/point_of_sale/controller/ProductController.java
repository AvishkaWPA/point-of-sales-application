package com.example.point_of_sale.controller;


import com.example.point_of_sale.dto.ProductDTO;
import com.example.point_of_sale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("save")
    public String saveProduct(@RequestBody  ProductDTO productDTO){
        productService.saveProduct(productDTO);
        return productDTO.getProductName();
    }
}
