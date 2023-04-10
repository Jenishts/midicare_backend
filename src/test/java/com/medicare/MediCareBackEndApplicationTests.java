package com.medicare;

import com.medicare.entity.Product;
import com.medicare.repo.UserRepo;
import com.medicare.service.ProductService;
import com.medicare.usermanager.auth.AuthenticationResponse;
import com.medicare.usermanager.auth.AuthenticationService;
import com.medicare.usermanager.auth.authenticationRequest;
import com.medicare.usermanager.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MediCareBackEndApplicationTests {




    @Autowired
    private ProductService productService;


    @Test
    void contextLoads() {
    }

    @Test
    public void addProductTest(){
        Product product=new Product();
        product.setProductName("EATRITE CHYAWANPRASH 1KG");
        product.setProductDescription("Eatrite Chyawanprash 1 Kg is an age-old ayurvedic formulation filled with goodness of many beneficial herbs and plant extracts. It is a vegetarian formula and can be taken during all seasons.");
product.setProductAvailability(true);
product.setPrice(300.00);
product.setDiscountPrice(260.00);
product.setSeller("Jenish");

productService.addProduct(product);
    }

}
