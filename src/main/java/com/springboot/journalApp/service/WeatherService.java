package com.springboot.journalApp.service;

import com.springboot.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String apiKey = "23298177ccd6372985cd493402c5beed";

    private static final String API = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city) {
        String finalAPI = API.replace("CITY", city).replace("API_KEY", apiKey);

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("key", "value");
//
//        User user = User.builder().userName("mohan").password("mohan1111").build();
//        HttpEntity<User> httpEntity = new HttpEntity<>(user, httpHeaders);

        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.PUT,null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }
}
