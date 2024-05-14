package com.example.demo1.service;

import com.example.demo1.controller.api.WeatherDataController;
import com.example.demo1.model.dto.WeatherDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    public WeatherDto getWeatherByCity(String cityName) {
        String API_KEY = "71dde62dea44f83a443bcf8ce5a30bb7";
        String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=cityName&appid=" + API_KEY + "&units=metric";
        String finalUrl = API_URL.replaceAll("cityName", cityName);
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForEntity(finalUrl, WeatherDto.class).getBody();
    }
}
