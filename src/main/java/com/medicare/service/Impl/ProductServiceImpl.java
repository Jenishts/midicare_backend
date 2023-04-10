package com.medicare.service.Impl;

import com.medicare.entity.Product;
import com.medicare.repo.ProductRepo;
import com.medicare.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;


    @Override
    public ResponseEntity<List<Product>> allProductList() {
        return new ResponseEntity<>(productRepo.findAll(), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<Product>> activeProductList() {
        return new ResponseEntity<>(productRepo.availableProductList(), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<String> addProduct(Product product) {
        if(product != null){
            productRepo.save(product);
            return new ResponseEntity<>("Product Saved", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Invalid Product Details", HttpStatus.UNAUTHORIZED);

    }

    @Override
    public ResponseEntity<String> deleteProduct(int id) {
        Optional<Product> product=productRepo.findById(id);
        if(product.isEmpty()){
            return new ResponseEntity<>("Enter a valid Product ID", HttpStatus.NOT_FOUND);
        }
        productRepo.delete(product.get());
        return new ResponseEntity<>("Product ID : " + id +" has been deleted", HttpStatus.ACCEPTED);
    }

    @Override
    public Optional<Product> findByProductId(int id) {
        return productRepo.findById(id);


    }
}
