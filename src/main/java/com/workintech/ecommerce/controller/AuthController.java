package com.workintech.ecommerce.controller;


import com.workintech.ecommerce.dto.RegisterUser;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public User register(@RequestBody RegisterUser registerUser){
        return authenticationService.register(registerUser.getName(),
                registerUser.getEmail(),
                registerUser.getPassword());
    }
    @PostMapping("/login")
    public User login(@RequestBody RegisterUser loginUser) {
        // Giriş işlemini gerçekleştir
        return authenticationService.login(loginUser.getEmail(), loginUser.getPassword());
    }
}
