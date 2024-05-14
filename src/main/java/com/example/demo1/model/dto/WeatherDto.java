package com.example.demo1.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WeatherDto {

    private List<Weather> weather;
    private Wind wind;
    @JsonProperty("temperature")
    private Main main;


    static protected class Weather {
        public String description;
    }

    static protected class Wind {
        public String speed;
    }

    static protected class Main{
        public String temp;
    }

}
