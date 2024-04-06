package com.pfc2.weather.service.mapper;

import com.pfc2.weather.persistence.entity.WeatherHistory;
import com.pfc2.weather.service.dto.ApiOpenWeatherMapRes;
import com.pfc2.weather.service.dto.ResponseWeather;
import com.pfc2.weather.service.dto.Weather;
import com.pfc2.weather.service.dto.WeatherHistoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Mapper(imports = {UUID.class, LocalDateTime.class})
public interface WeatherMapper {
    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    @Named("getCurrentWeatherCondition")
    static String getCurrentWeatherCondition(List<Weather> weather) {
        if (weather != null && !weather.isEmpty()) {
            return weather.get(0).getMain();
        }
        return "Unknown";
    }

    ResponseWeather toResponseWeather(WeatherHistory history);

    WeatherHistoryDTO toWeatherHistoryDTO(WeatherHistory history);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "tempMin", source = "main.tempMin")
    @Mapping(target = "tempMax", source = "main.tempMax")
    @Mapping(target = "lon", source = "coord.lon")
    @Mapping(target = "lat", source = "coord.lat")
    @Mapping(target = "humidity", source = "main.humidity")
    @Mapping(target = "created", expression = "java(LocalDateTime.now())")
    @Mapping(target = "weather", source = "weather", qualifiedByName = "getCurrentWeatherCondition")
    WeatherHistory toWeatherHistory(ApiOpenWeatherMapRes res);
}