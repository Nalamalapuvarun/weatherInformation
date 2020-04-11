package com.varun.interview.demo.service;

import com.varun.interview.demo.clientInvoker.WeatherInvoker;
import com.varun.interview.demo.json.WeatherJson;
import com.varun.interview.demo.json.WeatherResponse;
import com.varun.interview.demo.json.WeatherResponseJson;
import com.varun.interview.demo.transformer.WeatherTransformer;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceImplTest {

    @InjectMocks
    private WeatherServiceImpl classUnderTest;
    @Mock
    private WeatherTransformer weatherTransformer;
    @Mock
    private WeatherInvoker weatherInvoker;

    @Test
    public void testGetWeatherInformation() throws ParseException {
        WeatherJson weatherJson1 = WeatherJson.builder().build();
        WeatherJson weatherJson2 = WeatherJson.builder().build();
        WeatherResponse weatherResponse1 = WeatherResponse.builder().build();
        WeatherResponse weatherResponse2 = WeatherResponse.builder().build();
        List<WeatherResponse> list = new ArrayList<>();
        list.add(weatherResponse1);
        list.add(weatherResponse2);
        WeatherResponseJson expected = WeatherResponseJson.builder().weatherResponses(list).build();

        when(weatherTransformer.buildWeatherResponse(weatherJson1)).thenReturn(weatherResponse1);
        when(weatherTransformer.buildWeatherResponse(weatherJson1)).thenReturn(weatherResponse2);
        when(weatherTransformer.getLastYearEpochTime()).thenReturn(5L);

        when(weatherInvoker.getWeatherInformation(1L, 2L, 0)).thenReturn(weatherJson1);
        when(weatherInvoker.getWeatherInformation(1L, 2L, 5L)).thenReturn(weatherJson2);

        WeatherResponseJson actual = classUnderTest.getWeatherInformation(1L, 2L);

        assertThat(actual).isNotNull();
        assertThat(actual.getWeatherResponses().size()).isEqualTo(2);
        assertThat(actual.getWeatherResponses()).isEqualTo(expected.getWeatherResponses());
    }
}