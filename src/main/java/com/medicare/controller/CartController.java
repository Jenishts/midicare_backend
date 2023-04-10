package com.medicare.controller;

import com.medicare.entity.Product;
import com.medicare.service.CartServices;
import com.medicare.service.ProductService;
import com.medicare.usermanager.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {


    private final CartServices cartServices;
    private final ProductService productService;


    @GetMapping("/{id}")
    public ResponseEntity<String> add(@AuthenticationPrincipal User user, @PathVariable("id") int id){
        Product product=productService.findByProductId(id).get();
        return cartServices.addToCart(user, product);
    }
    @GetMapping("/remove/{id}")
    public ResponseEntity<String> remove(@AuthenticationPrincipal User user, @PathVariable("id") int id){
        Product product=productService.findByProductId(id).get();
        return cartServices.removeFromCart(user, product);
    }
}
