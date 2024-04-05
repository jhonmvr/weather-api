package com.pfc2.weather.service.dto;

import lombok.Data;

@Data
public class System {
    private String country;
    private long sunrise;
    private long sunset;
}
