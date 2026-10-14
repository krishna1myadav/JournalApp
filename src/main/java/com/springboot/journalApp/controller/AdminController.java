package com.springboot.journalApp.controller;


import com.springboot.journalApp.entity.User;
import com.springboot.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    public void getAllUsers(){
        List<User> all = userService.getAll();
    }
}
