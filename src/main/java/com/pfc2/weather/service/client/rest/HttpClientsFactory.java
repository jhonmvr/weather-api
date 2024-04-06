package com.pfc2.weather.service.client.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
@AllArgsConstructor
public class HttpClientsFactory {
    private final OpenWeatherMapClient openWeatherMapClient;
    private final TokenLoginClient tokenLoginClient;
}