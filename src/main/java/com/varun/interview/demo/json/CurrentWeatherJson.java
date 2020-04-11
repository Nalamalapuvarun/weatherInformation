package com.varun.interview.demo.json;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentWeatherJson {

    private long time;
    private String summary;
    private String icon;
    private double nearestStormDistance;
    private double nearestStormBearing;
    private double precipIntensity;
    private double precipProbability;
    private double temperature;
    private double apparentTemperature;
    private double dewPoint;
    private double humidity;
    private double pressure;
    private double windSpeed;
    private double windGust;
    private double windBearing;
    private double cloudCover;
    private double uvIndex;
    private double visibility;
    private double ozone;

}
