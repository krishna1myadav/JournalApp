package com.springboot.journalApp.controller;

import com.springboot.journalApp.entity.User;
import com.springboot.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }

    @PostMapping("/signup")
    public void signup(@RequestBody User user){
        userService.saveNewEntry(user);
    }

    @PostMapping("/login")
    public void login(@RequestBody User user){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
