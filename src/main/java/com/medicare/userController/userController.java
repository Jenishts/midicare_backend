package com.medicare.userController;

import com.medicare.usermanager.auth.AuthenticationResponse;
import com.medicare.usermanager.auth.AuthenticationService;
import com.medicare.usermanager.auth.RegisterRequest;
import com.medicare.usermanager.auth.authenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class userController {

    private final AuthenticationService authenticationService;



    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));

    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody authenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));

    }

    @GetMapping("/user")
    public ResponseEntity<String> userAccess(){
        return ResponseEntity.ok("Hi, I am a User, I don't have access to Admin login");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> userAdmin(){
        return ResponseEntity.ok("Hi, I am a Admin, I don't have access to User login");
    }
}
