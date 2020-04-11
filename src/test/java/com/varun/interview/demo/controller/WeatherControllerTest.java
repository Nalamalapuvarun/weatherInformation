package com.varun.interview.demo.controller;

import com.varun.interview.demo.json.WeatherResponseJson;
import com.varun.interview.demo.service.WeatherServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.ws.rs.BadRequestException;
import java.text.ParseException;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherControllerTest {

    @InjectMocks
    private WeatherController classUnderTest;
    @Mock
    private WeatherServiceImpl service;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testGetWeatherInfo() throws ParseException {
        WeatherResponseJson expected = WeatherResponseJson.builder().build();

        when(service.getWeatherInformation(1.0, 2.0)).thenReturn(expected);

        WeatherResponseJson actual = classUnderTest.getWeatherInfo(1.0, 2.0);

        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testGetWeatherInfo_givenLatitudeNull() throws ParseException {
        expectedException.expect(CustomException.class);
        expectedException.expectMessage("Latitude Value Must be valid");

        WeatherResponseJson actual = classUnderTest.getWeatherInfo(null, 2.0);

        assertThat(actual.getErrorMessage()).isEqualTo("Latitude Value Must be valid");

        verifyNoInteractions(service);
    }

    @Test
    public void testGetWeatherInfo_givenLongitudeNull() throws ParseException {
        expectedException.expect(CustomException.class);
        expectedException.expectMessage("Longitude Value Must be valid");

        WeatherResponseJson actual = classUnderTest.getWeatherInfo(2.0, null);

        assertThat(actual.getErrorMessage()).isEqualTo("Longitude Value Must be valid");

        verifyNoInteractions(service);
    }
}