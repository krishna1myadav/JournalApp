package com.springboot.journalApp.scheduler;


import com.springboot.journalApp.cache.AppCache;
import com.springboot.journalApp.entity.JournalEntry;
import com.springboot.journalApp.entity.User;
import com.springboot.journalApp.enums.Sentiment;
import com.springboot.journalApp.model.SentimentData;
import com.springboot.journalApp.repository.UserRepositoryImpl;
import com.springboot.journalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private KafkaTemplate<String, SentimentData> kafkaTemplate;

    @Autowired
    private AppCache appCache;

    @Scheduled(cron = "0 0 9 * * SUN")
    public void fetchUsersAndSenSadMail(){
        List<User> users = userRepository.getUserForSA();
        for(User user : users){
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<Sentiment> sentiments = journalEntries.stream().
                    filter(x -> x.getDate().isAfter(LocalDateTime.
                            now().minus(7, ChronoUnit.DAYS))).
                    map(x -> x.getSentiment()).collect(Collectors.toList());
            Map<Sentiment, Integer> sentimentCounts = new HashMap<>();
            for(Sentiment sentiment : sentiments){
                if(sentiment != null){
                    sentimentCounts.put(sentiment, sentimentCounts.getOrDefault(sentiment, 0) + 1);
                }
            }
            Sentiment mostFrequentSentiment = null;
            int maxCount = 0;
            for(Map.Entry<Sentiment, Integer> entry : sentimentCounts.entrySet()){
                if(entry.getValue() > maxCount){
                    maxCount = entry.getValue();
                    mostFrequentSentiment = entry.getKey();
                }
            }
            if(mostFrequentSentiment != null){
                SentimentData sentimentalData = SentimentData.builder().email(user.getEmail()).sentiment("sentiment for last 7 days " + mostFrequentSentiment).build();
                kafkaTemplate.send("weekly-sentiment", sentimentalData.getEmail(), sentimentalData);
            }
        }
    }

    @Scheduled(cron = "0 0/10 * ? * *")
    public void clearAppCache(){
        appCache.init();
    }
}
