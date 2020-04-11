package com.varun.interview.demo.controller;

import com.varun.interview.demo.json.WeatherResponseJson;
import com.varun.interview.demo.service.WeatherServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherControllerTest {

    @InjectMocks
    private WeatherController classUnderTest;
    @Mock
    private WeatherServiceImpl service;

    @Test
    public void testGetWeatherInfo() throws ParseException {
        WeatherResponseJson expected = WeatherResponseJson.builder().build();

        when(service.getWeatherInformation(1, 2)).thenReturn(expected);

        WeatherResponseJson actual = classUnderTest.getWeatherInfo("1", "2");

        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(expected);
    }

}