package com.pfc2.weather.web.controller;

import com.pfc2.weather.service.WeatherService;
import com.pfc2.weather.service.dto.RequestWeather;
import com.pfc2.weather.service.dto.ResponseWeather;
import com.pfc2.weather.service.dto.WeatherHistoryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
@Tag(name = "Weather", description = "APi for weather information.")
public class WeatherController {
    private final WeatherService weatherService;

    @Operation(summary = "Obtain information about the climate of a place.")
    @PostMapping
    ResponseEntity<ResponseWeather> getCurrentWeatherData(@RequestBody @Valid RequestWeather data) {
        log.info("Endpoint to get Current Weather Data: {}", data);
        return ResponseEntity.ok(weatherService.getCurrentWeatherData(data));
    }

    @Operation(summary = "Obtain weather query history.")
    @GetMapping("/history")
    ResponseEntity<List<WeatherHistoryDTO>> getWeatherHistory() {
        log.info("Endpoint to get Weather History");
        return ResponseEntity.ok(weatherService.getWeatherHistory());
    }
}