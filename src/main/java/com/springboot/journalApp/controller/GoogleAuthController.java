package com.springboot.journalApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth/google")
public class GoogleAuthController {

    @GetMapping("/callback")
    public ResponseEntity<?> handleGoogleCallback(@RequestParam String code){
        try {
            // 1. Exchange auth code for tokens
            String tokenEndpoint = "https://oauth2.googleapis.com/token";
            Map<String, String> params = new HashMap<>();
            params.put("code", code);
            params.put("client_id", clientId);
            params.put("client_secret", clientSecret);
            params.put("redirect_uri", "https://developers.google.com/oauthplayground");
            params.put("grant_type", "authorization_code");
        }catch (Exception e){

        }
    }
}
