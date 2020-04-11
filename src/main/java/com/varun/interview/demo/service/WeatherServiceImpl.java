package com.varun.interview.demo.service;

import com.varun.interview.demo.clientInvoker.WeatherInvoker;
import com.varun.interview.demo.json.WeatherJson;
import com.varun.interview.demo.json.WeatherResponse;
import com.varun.interview.demo.json.WeatherResponseJson;
import com.varun.interview.demo.transformer.WeatherTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl {

    private final WeatherTransformer weatherTransformer;
    private final WeatherInvoker weatherInvoker;

    public WeatherResponseJson getWeatherInformation(double latitude, double longitude) throws ParseException {
        WeatherJson weatherJson = weatherInvoker.getWeatherInformation(latitude, longitude, 0);
        WeatherResponse weatherResponse = weatherTransformer.buildWeatherResponse(weatherJson);

        WeatherJson weatherJsonforLastYear = weatherInvoker.getWeatherInformation(latitude, longitude, weatherTransformer.getLastYearEpochTime());
        WeatherResponse weatherResponseForLastYear = weatherTransformer.buildWeatherResponse(weatherJsonforLastYear);

        List<WeatherResponse> weatherResponses = new ArrayList<>();
        weatherResponses.add(weatherResponse);
        weatherResponses.add(weatherResponseForLastYear);

        return WeatherResponseJson.builder()
                .weatherResponses(weatherResponses)
                .build();
    }
}
