package com.varun.interview.demo.transformer;

import com.varun.interview.demo.json.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class WeatherTransformerTest {

    @InjectMocks
    private WeatherTransformer classUnderTest;
    private WeatherJson weatherJson;

    @Before
    public void setUp() {
        List<DailyWeatherData> data = new ArrayList<>();
        DailyWeatherData dailyWeatherData = DailyWeatherData.builder()
                .sunriseTime(1586602680L)
                .sunsetTime(1586650260L)
                .temperatureHigh(57.41)
                .temperatureHighTime(1586641320L)
                .temperatureLow(44.35)
                .temperatureLowTime(1586688720L)
                .build();
        data.add(dailyWeatherData);
        DailyWeather dailyWeather = DailyWeather.builder()
                .data(data)
                .build();
        weatherJson = WeatherJson.builder()
                .daily(dailyWeather)
                .currently(CurrentWeatherJson.builder()
                        .time(1586620475L)
                        .temperature(47.43)
                        .build())
                .build();
    }

    @Test
    public void givenWeatherJson_expectToBuildWeatherResponse() {
        WeatherResponse expected = WeatherResponse.builder()
                .date("04/11/2020")
                .time("11:54:35")
                .temperature(47.43)
                .sunRiseTime("06:58:00")
                .sunsetTime("20:11:00")
                .temperatureHigh(57.41)
                .temperatureHighTime("17:42:00")
                .temperatureLow(44.35)
                .temperatureLowTime("06:52:00")
                .build();

        WeatherResponse actual = classUnderTest.buildWeatherResponse(weatherJson);
        assertThat(actual).isEqualToComparingFieldByField(expected);
        assertThat(actual).isNotNull();
    }

    @Test
    public void getEpochTimeOfLastYear() throws ParseException {
        long actual = classUnderTest.getLastYearEpochTime();
        assertThat(actual).isNotNull();
    }
}