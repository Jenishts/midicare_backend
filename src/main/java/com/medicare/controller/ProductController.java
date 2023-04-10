package com.medicare.controller;

import com.medicare.entity.Product;
import com.medicare.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    @PostMapping("/add")
    ResponseEntity<String> saveProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/list")
    ResponseEntity<List<Product>> productList(){
       return productService.allProductList();
    }

    @GetMapping()
    ResponseEntity<List<Product>> activeProduct(){
        return productService.activeProductList();
    }



}
