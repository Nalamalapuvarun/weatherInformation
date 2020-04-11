package com.varun.interview.demo.controller;

import com.varun.interview.demo.json.WeatherResponseJson;
import com.varun.interview.demo.service.WeatherServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class WeatherController {

    private final WeatherServiceImpl weatherService;

    @ResponseStatus(CREATED)
    @GetMapping(value = "/getWeather/{latitude}/{longitude}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "getWeatherInfo",
            notes = "Retrieved the Weather information for the given location for today and same time last year")
    public WeatherResponseJson getWeatherInfo(@PathVariable("latitude") Double latitude,
                                              @PathVariable("longitude") Double longitude) throws ParseException {
        //42.335190/-83.049190
        if (isNull(latitude) || latitude > 90 || latitude < -90) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Latitude Value Must be valid");
        }
        if (isNull(longitude) || longitude > 80 || longitude < -180) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Longitude Value Must be valid");
        }

        return weatherService.getWeatherInformation(latitude, longitude);
    }
}
