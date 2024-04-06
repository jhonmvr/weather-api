package com.pfc2.weather.service.dto;

import lombok.Data;

import java.util.List;

@Data

public class ApiOpenWeatherMapRes {
    private RequestWeather coord;
    private List<Weather> weather;
    private MainDTO main;
    private String base;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private System sys;
    private int timezone;
    private long id;
    private String name;
    private int cod;
}
