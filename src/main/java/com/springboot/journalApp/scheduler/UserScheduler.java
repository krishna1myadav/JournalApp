package com.springboot.journalApp.scheduler;


import com.springboot.journalApp.entity.JournalEntry;
import com.springboot.journalApp.entity.User;
import com.springboot.journalApp.repository.UserRepositoryImpl;
import com.springboot.journalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepository;


    public void fetchUsersAndSenSadMail(){
        List<User> users = userRepository.getUserForSA();
        for(User user : users){
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<String> filteredEntries = journalEntries.stream().
                    filter(x -> x.getDate().isAfter(LocalDateTime.
                            now().minus(7, ChronoUnit.DAYS))).
                    map(x -> x.getContent()).collect(Collectors.toList());
            String entry = String.join(" ", filteredEntries);
        }
    }
}
