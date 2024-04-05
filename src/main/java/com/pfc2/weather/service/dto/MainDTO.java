package com.pfc2.weather.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MainDTO implements Serializable {
    private Double temp;

    @JsonProperty("feels_like")
    private Double feelsLike;

    @JsonProperty("temp_min")
    private Double tempMin;

    @JsonProperty("temp_max")
    private Double tempMax;

    private Double pressure;
    private Double humidity;

    @JsonProperty("sea_level")
    private Double seaLevel;

    @JsonProperty("grnd_level")
    private Double grndLevel;
}
