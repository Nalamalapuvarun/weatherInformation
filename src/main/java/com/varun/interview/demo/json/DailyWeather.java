package com.varun.interview.demo.json;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyWeather {

    private String summary;
    private String icon;
    private List<DailyWeatherData> data;

}
