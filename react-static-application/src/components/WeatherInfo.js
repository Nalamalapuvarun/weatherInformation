import React from 'react'

const WeatherInfo = ({weatherResponse}) => {
    return (
        <div>
            <center><h1>Temperature Information</h1></center>
            {weatherResponse.map((response) => (
                <div class="card">
                    <div class="card-body">
                        <h6>Date: {response.date}</h6>
                        <h6>Time: {response.time}</h6>
                        <h6>Temperature: {response.temperature}</h6>
                        <h6>Sunrise Time: {response.sunRiseTime}</h6>
                        <h6>Sunset Time: {response.sunsetTime}</h6>
                        <h6>Temeperature High: {response.temperatureHigh}</h6>
                        <h6>Temeperature High Time: {response.temperatureHighTime}</h6>
                        <h6>Temeperature Low: {response.temperatureLow}</h6>
                        <h6>Temeperature Low Time: {response.temperatureLowTime}</h6>
                    </div>
                </div>
            ))}
        </div>
    )
};

export default WeatherInfo