package com.springboot.journalApp.service;

import com.springboot.journalApp.entity.User;
import com.springboot.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static  org.mockito.Mockito.*;

@SpringBootTest
public class UserDetailsServiceImplTest {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @Test
    void loadUserByUsernameTest(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("mohan").
                password("kfajlal").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("mohan");
        Assertions.assertNotNull(user);
    }
}
