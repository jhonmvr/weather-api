package com.pfc2.weather.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestWeather {
    Double lat;
    Double lon;
}
