package com.medicare.usermanager.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    // Not working. ........
    private final AuthenticationService authenticationService;

    @PostMapping("req")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));

    }

    @PostMapping("auth")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody authenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));

    }

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from user after logged in");
    }

}
