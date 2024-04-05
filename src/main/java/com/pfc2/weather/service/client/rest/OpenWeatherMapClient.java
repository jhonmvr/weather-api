package com.pfc2.weather.service.client.rest;


import com.pfc2.weather.service.dto.ApiOpenWeatherMapRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "openWeatherMapClient", url = "${services.open-weather-map}")
public interface OpenWeatherMapClient {
    @GetMapping
    ApiOpenWeatherMapRes getCurrentWeatherData(
            @RequestParam("lat") Double lat,
            @RequestParam("lon") Double lon,
            @RequestParam("appid") String appid);
}