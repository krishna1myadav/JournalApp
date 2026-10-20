package com.springboot.journalApp.cache;


import com.springboot.journalApp.entity.ConfigJournalAppEntry;
import com.springboot.journalApp.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public enum keys{
        WEATHER_API;
    }

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

        public Map<String, String> appCache = new HashMap<>();

    @PostConstruct
    public void init(){
        List<ConfigJournalAppEntry> all = configJournalAppRepository.findAll();
        for(ConfigJournalAppEntry configJournalAppEntry : all){
            appCache.put(configJournalAppEntry.getKey(), configJournalAppEntry.getValue());
        }
    }
}
