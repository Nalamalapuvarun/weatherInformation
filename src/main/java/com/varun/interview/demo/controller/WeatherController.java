package com.varun.interview.demo.controller;

import com.varun.interview.demo.json.WeatherResponseJson;
import com.varun.interview.demo.service.WeatherServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

import static java.lang.Long.valueOf;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class WeatherController {

    private final WeatherServiceImpl weatherService;

    @PostMapping(value = "/getWeather", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "getWeatherInfo",
            notes = "Retrieved the Weather information for the given location for today and same time last year")
    public WeatherResponseJson getWeatherInfo(@RequestHeader("latitude") String latitude,
                                              @RequestHeader("longitude") String longitude) throws ParseException {

        return weatherService.getWeatherInformation(valueOf(latitude), valueOf(longitude));
    }
}
