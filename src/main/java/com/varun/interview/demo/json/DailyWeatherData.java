package com.varun.interview.demo.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyWeatherData {
    private long time;
    private String summary;
    private String icon;
    private long sunriseTime;
    private long sunsetTime;
    private double moonPhase;
    private double precipIntensity;
    private double precipIntensityMax;
    private long precipIntensityMaxTime;
    private double precipProbability;
    private String precipType;
    private double temperatureHigh;
    private long temperatureHighTime;
    private double temperatureLow;
    private long temperatureLowTime;
    private double apparentTemperatureHigh;
    private long apparentTemperatureHighTime;
    private double apparentTemperatureLow;
    private long apparentTemperatureLowTime;
    private double dewPoint;
    private double humidity;
    private double pressure;
    private double windSpeed;
    private double windGust;
    private long windGustTime;
    private double windBearing;
    private double cloudCover;
    private double uvIndex;
    private long uvIndexTime;
    private long visibility;
    private long ozone;
    private double temperatureMin;
    private long temperatureMinTime;
    private double temperatureMax;
    private long temperatureMaxTime;
    private double apparentTemperatureMin;
    private long apparentTemperatureMinTime;
    private double apparentTemperatureMax;
    private long apparentTemperatureMaxTime;

}

