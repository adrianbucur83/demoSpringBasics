package com.example.demo1.controller.api;

import com.example.demo1.model.dto.WeatherDto;
import com.example.demo1.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WeatherDataController {

    private final WeatherService weatherService;
    @GetMapping("/weather")
    ResponseEntity<WeatherDto> getWeatherByCity(@RequestParam String cityName) {
        return ResponseEntity.ok(weatherService.getWeatherByCity(cityName));
    }
}
