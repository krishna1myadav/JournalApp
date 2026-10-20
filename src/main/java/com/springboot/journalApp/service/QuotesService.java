package com.springboot.journalApp.service;

import org.springframework.stereotype.Component;

@Component
public class QuotesService {
    private static final String apiKey = "vAmksoBxgX3MQdq8qvcFzO2di24MC4pjjyjBDvMA779391fe";

    private static final String API = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    public String quotes(String city) {

    }
}
