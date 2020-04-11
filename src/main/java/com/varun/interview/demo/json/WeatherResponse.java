package com.varun.interview.demo.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {

    private String date;
    private String time;
    private double temperature;
    private String sunRiseTime;
    private String sunsetTime;
    private double temperatureHigh;
    private String temperatureHighTime;
    private double temperatureLow;
    private String temperatureLowTime;

}
