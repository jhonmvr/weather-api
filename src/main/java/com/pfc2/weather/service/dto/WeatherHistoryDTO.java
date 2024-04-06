package com.pfc2.weather.service.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class WeatherHistoryDTO {
    Double humidity;
    private UUID id;
    private Double lat;
    private Double lon;
    private String weather;
    private Double tempMin;
    private Double tempMax;
    private LocalDateTime created;
}
