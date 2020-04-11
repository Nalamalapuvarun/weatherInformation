package com.varun.interview.demo.clientInvoker;

import com.varun.interview.demo.json.WeatherJson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class WeatherInvoker {

    private static final String URl = "https://api.darksky.net/forecast/0b67f8f549800f7bdeccc85500ba9324/";
    private RestTemplate restTemplate = new RestTemplate();

    public WeatherJson getWeatherInformation(double latitude, double longitude, long time) {

        String weatherUrl;
        if (time == 0) {
            weatherUrl = URl + latitude + "," + longitude;
        } else {
            weatherUrl = URl + latitude + "," + longitude + "," + time;
        }

        return restTemplate.getForObject(weatherUrl,
                WeatherJson.class);
    }
}
