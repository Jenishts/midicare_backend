package com.medicare.service;

import com.medicare.entity.Product;
import com.medicare.usermanager.user.User;
import org.springframework.http.ResponseEntity;

public interface CartServices {

    public ResponseEntity<String> addToCart(User user, Product product);

    public ResponseEntity<String> removeFromCart(User user, Product product);

}
