package com.pfc2.weather.service.dto;

import lombok.Data;

@Data
public class ResponseWeather {
    private String weather;
    private Double tempMin;
    private Double tempMax;
    private Double humidity;
}
