package com.varun.interview.demo.json;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherJson {

    private DailyWeather daily;
    private CurrentWeatherJson currently;
    private String timezone;

}
