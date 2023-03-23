package com.medicare.usermanager.auth;

import com.medicare.repo.UserRepo;
import com.medicare.usermanager.config.JwtService;
import com.medicare.usermanager.user.Role;
import com.medicare.usermanager.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user= User.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepo.save(user);

        String jwtToken =jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(authenticationRequest request) {

        System.err.println(request.getEmail());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),

                        request.getPassword()
                )

        );

        var user=userRepo.findByEmail(request.getEmail()).orElseThrow(()->new UsernameNotFoundException("User not found"));

//        user.setPassword(passwordEncoder.encode(user.getPassword()));

        String jwtToken =jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
