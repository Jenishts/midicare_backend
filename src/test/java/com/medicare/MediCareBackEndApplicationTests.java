package com.medicare;

import com.medicare.repo.UserRepo;
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
    private AuthenticationService authenticationService;


    @Autowired
    private UserRepo userRepo;


    @Test
    void contextLoads() {
    }


    @Test
    public void userController(){

        authenticationRequest authentication=new authenticationRequest();
        authentication.setEmail("google@gmail.com");
        authentication.setPassword("pass");

        User user=userRepo.findByEmail("google@gmail.com").get();

        System.out.println(user.toString());

       AuthenticationResponse authenticationResponse=authenticationService.authenticate(authentication);
    }
}
