package com.example.demo1.config;

import com.example.demo1.model.WelcomeMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean(name = "welcomeMessage")

    public WelcomeMessage getWelcomeMessage(){
        return new WelcomeMessage("New welcome message ");
    }

    @Bean(name = "welcomeMessage2")
    public WelcomeMessage getWelcomeMessage2(){
        return new WelcomeMessage("<h1>Second welcome message</h1>");
    }

    @Bean(name ="welcomeMessagePayment")
    public WelcomeMessage getWelcomeMessagePayment(){
        return new WelcomeMessage("PAYMENTS");
    }

    @Bean(name = "defaultSettings")
    public AppSettings getAppSettings(){
        AppSettings appSettings = new AppSettings();
        appSettings.setSetting1("value1");
        appSettings.setSetting2("value2");
        return appSettings;
    }

}
