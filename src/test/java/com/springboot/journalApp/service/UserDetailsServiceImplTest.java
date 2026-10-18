package com.springboot.journalApp.service;

import com.springboot.journalApp.repository.UserRepository;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsServiceImplTest {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    void loadUserByUsernameTest(){
        UserDetails user = userDetailsService.loadUserByUsername("mohan");
    }
}
