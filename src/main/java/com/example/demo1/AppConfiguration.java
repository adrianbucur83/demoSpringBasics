package com.example.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public WelcomeMessage getWelcomeMessage(){
        return new WelcomeMessage("<h1>New welcome message</h1>");
    }

}
