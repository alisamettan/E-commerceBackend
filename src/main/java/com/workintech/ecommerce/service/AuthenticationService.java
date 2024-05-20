package com.workintech.ecommerce.service;


import com.workintech.ecommerce.entity.Role;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.exceptions.ApiException;
import com.workintech.ecommerce.repository.RoleRepository;
import com.workintech.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String fullName,String email,String password){
        Optional<User> existingUser=userRepository.findUserByEmail(email);
        if(existingUser.isPresent()){
            throw new ApiException("A user with this email already exists.: "+email, HttpStatus.BAD_REQUEST);
        }

        String encodedPassword=passwordEncoder.encode(password);
        Role role=new Role();
        role.setAuthority("USER");
        Role userRole = roleRepository.save(role);


        List<Role> roles=new ArrayList<>();
        roles.add(userRole);

        User user=new User();
        user.setName(fullName);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setAuthorities(roles);

        return userRepository.save(user);
    }

    public User login(String email, String password) {
        // E-posta adresine göre kullanıcıyı bul
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Kullanıcının şifresini kontrol et
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // Kullanıcıyı döndür
        return user;
    }
}
