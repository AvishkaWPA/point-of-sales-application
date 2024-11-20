package com.example.point_of_sale.controller;


import com.example.point_of_sale.dto.ProductDTO;
import com.example.point_of_sale.service.ProductService;
import com.example.point_of_sale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("save")
    public ResponseEntity<StandardResponse> saveProduct(@RequestBody  ProductDTO productDTO){
        productService.saveProduct(productDTO);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"Success!",null), HttpStatus.CREATED);
    }
}
