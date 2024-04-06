package com.pfc2.weather.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "WEATHER_HISTORY")
@Table(indexes = {
        @Index(name = "fn_lat", columnList = "lat"),
        @Index(name = "fn_lon", columnList = "lon")
})

public class WeatherHistory implements Serializable {
    @Id
    private UUID id;

    @Column(nullable = false)
    private Double lat;

    @Column(nullable = false)
    private Double lon;

    private String weather;

    @Column(name = "TEMP_MIN")
    private Double tempMin;

    @Column(name = "TEMP_MAX")
    private Double tempMax;

    private Double humidity;

    private LocalDateTime created;
}
