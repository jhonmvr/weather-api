package com.pfc2.weather.service.mapper;

import com.pfc2.weather.persistence.entity.WeatherHistory;
import com.pfc2.weather.service.dto.ApiOpenWeatherMapRes;
import com.pfc2.weather.service.dto.MainDTO;
import com.pfc2.weather.service.dto.RequestWeather;
import com.pfc2.weather.service.dto.ResponseWeather;
import com.pfc2.weather.service.dto.WeatherHistoryDTO;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T17:42:08-0500",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class WeatherMapperImpl implements WeatherMapper {

    @Override
    public ResponseWeather toResponseWeather(WeatherHistory history) {
        if ( history == null ) {
            return null;
        }

        ResponseWeather responseWeather = new ResponseWeather();

        responseWeather.setWeather( history.getWeather() );
        responseWeather.setTempMin( history.getTempMin() );
        responseWeather.setTempMax( history.getTempMax() );
        responseWeather.setHumidity( history.getHumidity() );

        return responseWeather;
    }

    @Override
    public WeatherHistoryDTO toWeatherHistoryDTO(WeatherHistory history) {
        if ( history == null ) {
            return null;
        }

        WeatherHistoryDTO weatherHistoryDTO = new WeatherHistoryDTO();

        weatherHistoryDTO.setId( history.getId() );
        weatherHistoryDTO.setLat( history.getLat() );
        weatherHistoryDTO.setLon( history.getLon() );
        weatherHistoryDTO.setWeather( history.getWeather() );
        weatherHistoryDTO.setTempMin( history.getTempMin() );
        weatherHistoryDTO.setTempMax( history.getTempMax() );
        weatherHistoryDTO.setHumidity( history.getHumidity() );
        weatherHistoryDTO.setCreated( history.getCreated() );

        return weatherHistoryDTO;
    }

    @Override
    public WeatherHistory toWeatherHistory(ApiOpenWeatherMapRes res) {
        if ( res == null ) {
            return null;
        }

        WeatherHistory weatherHistory = new WeatherHistory();

        weatherHistory.setTempMin( resMainTempMin( res ) );
        weatherHistory.setTempMax( resMainTempMax( res ) );
        weatherHistory.setLon( resCoordLon( res ) );
        weatherHistory.setLat( resCoordLat( res ) );
        weatherHistory.setHumidity( resMainHumidity( res ) );
        weatherHistory.setWeather( WeatherMapper.getCurrentWeatherCondition( res.getWeather() ) );

        weatherHistory.setId( UUID.randomUUID() );
        weatherHistory.setCreated( LocalDateTime.now() );

        return weatherHistory;
    }

    private Double resMainTempMin(ApiOpenWeatherMapRes apiOpenWeatherMapRes) {
        MainDTO main = apiOpenWeatherMapRes.getMain();
        if ( main == null ) {
            return null;
        }
        return main.getTempMin();
    }

    private Double resMainTempMax(ApiOpenWeatherMapRes apiOpenWeatherMapRes) {
        MainDTO main = apiOpenWeatherMapRes.getMain();
        if ( main == null ) {
            return null;
        }
        return main.getTempMax();
    }

    private Double resCoordLon(ApiOpenWeatherMapRes apiOpenWeatherMapRes) {
        RequestWeather coord = apiOpenWeatherMapRes.getCoord();
        if ( coord == null ) {
            return null;
        }
        return coord.getLon();
    }

    private Double resCoordLat(ApiOpenWeatherMapRes apiOpenWeatherMapRes) {
        RequestWeather coord = apiOpenWeatherMapRes.getCoord();
        if ( coord == null ) {
            return null;
        }
        return coord.getLat();
    }

    private Double resMainHumidity(ApiOpenWeatherMapRes apiOpenWeatherMapRes) {
        MainDTO main = apiOpenWeatherMapRes.getMain();
        if ( main == null ) {
            return null;
        }
        return main.getHumidity();
    }
}
