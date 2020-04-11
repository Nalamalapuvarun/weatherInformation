package com.varun.interview.demo.clientInvoker;

import com.varun.interview.demo.json.WeatherJson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class WeatherInvokerTest {

    @InjectMocks
    private WeatherInvoker classUnderTest;

    @Test
    public void testGetWeatherInformation() {
        WeatherJson actual = classUnderTest.getWeatherInformation(42.335190, -83.049190, 0);
        assertThat(actual).isNotNull();
        assertThat(actual).isExactlyInstanceOf(WeatherJson.class);
    }

    @Test
    public void testGetWeatherInformation_givenTime() {
        WeatherJson actual = classUnderTest.getWeatherInformation(42.335190, -83.049190, 1555002167);
        assertThat(actual).isNotNull();
        assertThat(actual).isExactlyInstanceOf(WeatherJson.class);
    }

}