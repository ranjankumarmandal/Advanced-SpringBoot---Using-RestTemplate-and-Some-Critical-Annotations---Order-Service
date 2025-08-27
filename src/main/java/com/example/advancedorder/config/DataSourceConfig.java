package com.example.advancedorder.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DataSourceConfig {

    @PostConstruct
    public void setup() {
        System.out.println("Dev profile loaded: using H2 database");
    }
}

