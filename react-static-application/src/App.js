import React, {Component} from 'react';
import WeatherInfo from './components/WeatherInfo';

class App extends Component {
    render() {
        return (
            <WeatherInfo weatherResponse={this.state.weatherResponse} />
        )
    }
    state = {
        weatherResponse: []
    };

    componentDidMount() {
        fetch('http://localhost:8081/v1/getWeather/42.335190/-83.049190')
            .then(res => res.json())
            .then((data) => {
                let weatherResponses = [];
                weatherResponses = data.weatherResponses;
                this.setState({ weatherResponse: weatherResponses })
            })
            .catch(console.log)
    }
}

export default App;
