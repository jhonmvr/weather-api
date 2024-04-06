package com.pfc2.weather.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Weather implements Serializable {
    private Integer id;
    private String main;
    private String description;
    private String icon;
}
