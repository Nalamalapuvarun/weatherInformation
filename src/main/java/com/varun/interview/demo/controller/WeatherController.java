package com.varun.interview.demo.controller;

import com.varun.interview.demo.json.WeatherResponseJson;
import com.varun.interview.demo.service.WeatherServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

import static java.lang.Double.valueOf;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class WeatherController {

    private final WeatherServiceImpl weatherService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/getWeather/{latitude}/{longitude}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "getWeatherInfo",
            notes = "Retrieved the Weather information for the given location for today and same time last year")
    public WeatherResponseJson getWeatherInfo(@PathVariable("latitude") double latitude,
                                              @PathVariable("longitude") double longitude) throws ParseException {
        //42.335190/-83.049190

        return weatherService.getWeatherInformation(valueOf(latitude), valueOf(longitude));
    }
}
