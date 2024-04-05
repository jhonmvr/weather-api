package com.pfc2.weather.service;


import com.pfc2.weather.persistence.entity.WeatherHistory;
import com.pfc2.weather.persistence.repository.WeatherHistoryRepository;
import com.pfc2.weather.service.client.rest.HttpClientsFactory;
import com.pfc2.weather.service.dto.ApiOpenWeatherMapRes;
import com.pfc2.weather.service.dto.RequestWeather;
import com.pfc2.weather.service.dto.ResponseWeather;
import com.pfc2.weather.service.dto.WeatherHistoryDTO;
import com.pfc2.weather.service.mapper.WeatherMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class WeatherService {
    private final HttpClientsFactory clientsFactory;
    private final WeatherHistoryRepository historyRepository;
    private final String appId;

    public WeatherService(HttpClientsFactory clientsFactory, WeatherHistoryRepository historyRepository, @Value("${app.secrets.open-weather.app-id}") String appid) {
        this.clientsFactory = clientsFactory;
        this.historyRepository = historyRepository;
        this.appId = appid;
    }

    @Transactional
    public ResponseWeather getCurrentWeatherData(RequestWeather data) {
        WeatherHistory weatherHistory = null;
        var optional = historyRepository.findByLatAndLon(data.getLat(), data.getLon());
        if (optional.isPresent()) {
            if (optional.get().getCreated().isAfter(LocalDateTime.now().minusMinutes(10))) {
                weatherHistory = optional.get();
                log.info("DB: {}", weatherHistory);
            } else {
                log.info("ID {}", optional.get().getId());
                historyRepository.deleteById(optional.get().getId());
            }
        }
        if (weatherHistory == null) {
            ApiOpenWeatherMapRes response = clientsFactory.getOpenWeatherMapClient().getCurrentWeatherData(data.getLat(), data.getLon(), appId);
            log.info("Se consume API de Weather: {}", response);
            weatherHistory = WeatherMapper.INSTANCE.toWeatherHistory(response);
            historyRepository.save(weatherHistory);
        }
        return WeatherMapper.INSTANCE.toResponseWeather(weatherHistory);
    }


    public List<WeatherHistoryDTO> getWeatherHistory() {
        return historyRepository.findAll().stream()
                .map(WeatherMapper.INSTANCE::toWeatherHistoryDTO)
                .toList();
    }
}