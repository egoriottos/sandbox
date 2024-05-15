package com.example.authandauthz.controllers;

import com.example.authandauthz.entities.User;
import com.example.authandauthz.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test/")
@AllArgsConstructor
public class TestController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to AuthAndAuthz!";
    }
    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String pageForUser(){
        return "This is an user";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String pageForAdmin(){
        return "This is an admin";
    }

    @GetMapping("/all")
    public String pageForAll(){
        return "This page for all";
    }
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
