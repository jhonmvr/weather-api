package com.pfc2.weather.service.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
public class Weather implements Serializable {
    private Integer id;
    private String main;
    private String description;
    private String icon;
}
