package com.medicare.service;

import com.medicare.entity.Product;
import org.springframework.http.ResponseEntity;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    ResponseEntity<List<Product>> allProductList();

    ResponseEntity<List<Product>> activeProductList();

    ResponseEntity<String> addProduct(Product product);

    ResponseEntity<String> deleteProduct(int id);

    Optional<Product> findByProductId(int id);




}
