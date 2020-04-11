package com.varun.interview.demo.transformer;

import com.varun.interview.demo.json.WeatherJson;
import com.varun.interview.demo.json.WeatherResponse;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class WeatherTransformer {

    public WeatherResponse buildWeatherResponse(WeatherJson weatherJson) {
        return WeatherResponse.builder()
                .date(convertEpochTimeToDate(weatherJson.getCurrently().getTime()))
                .time(convertEpochTimeToTime(weatherJson.getCurrently().getTime()))
                .temperature(weatherJson.getCurrently().getTemperature())
                .sunRiseTime(convertEpochTimeToTime(weatherJson.getDaily().getData().get(0).getSunriseTime()))
                .sunsetTime(convertEpochTimeToTime(weatherJson.getDaily().getData().get(0).getSunsetTime()))
                .temperatureHigh(weatherJson.getDaily().getData().get(0).getTemperatureHigh())
                .temperatureHighTime(convertEpochTimeToTime(weatherJson.getDaily().getData().get(0).getTemperatureHighTime()))
                .temperatureLow(weatherJson.getDaily().getData().get(0).getTemperatureLow())
                .temperatureLowTime(convertEpochTimeToTime(weatherJson.getDaily().getData().get(0).getTemperatureLowTime()))
                .build();
    }

    public long getLastYearEpochTime() throws ParseException {
        Calendar lastYearToday = Calendar.getInstance();
        lastYearToday.add(Calendar.YEAR, -1);
        Date time = lastYearToday.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String s = simpleDateFormat.format(time);
        return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
                .parse(s)
                .getTime() / 1000;
    }

    private String convertEpochTimeToDate(long epochTime) {
        return new SimpleDateFormat("MM/dd/yyyy")
                .format(new Date(epochTime * 1000));
    }

    private String convertEpochTimeToTime(long epochTime) {
        return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
                .format(new Date(epochTime * 1000))
                .split(" ")[1];
    }
}
