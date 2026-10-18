package com.springboot.journalApp.service;

import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsServiceImplTest {
    private UserDetailsServiceImpl userDetailsService;

    void loadUserByUsernameTest(){
        UserDetails user = userDetailsService.loadUserByUsername("mohan");
    }
}
