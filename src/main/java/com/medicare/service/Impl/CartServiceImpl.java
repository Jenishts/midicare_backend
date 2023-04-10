package com.medicare.service.Impl;

import com.medicare.entity.Cart;
import com.medicare.entity.Product;
import com.medicare.repo.CartRepo;
import com.medicare.service.CartServices;
import com.medicare.usermanager.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartServices {

    private final CartRepo cartRepo;

    @Override
    public ResponseEntity<String> addToCart(User user, Product product) {
        if(product.isProductAvailability()){
            Cart cart=new Cart();
            cart.setUser(user);
            cart.setProduct(product);
            cartRepo.save(cart);
            return new ResponseEntity<>("Added to cart", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Out of stock", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> removeFromCart(User user, Product product) {
        Cart cart=new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cartRepo.delete(cart);
        return  new ResponseEntity<>("Item removed from cart", HttpStatus.OK);
    }
}
