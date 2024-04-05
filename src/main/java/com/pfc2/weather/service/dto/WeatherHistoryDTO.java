package com.pfc2.weather.service.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class WeatherHistoryDTO {
    private UUID id;
private Double lat;
private Double lon;
private String weather;
private Double tempMin;
private Double tempMax;
    Double humidity;
private LocalDateTime created;
}
