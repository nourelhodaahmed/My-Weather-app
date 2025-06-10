package com.android.myweather.presenation.viewmodel.mapper

import com.android.myweather.R
import com.android.myweather.domain.model.Weather
import com.android.myweather.presenation.viewmodel.state.HourlyForecastUiState
import com.android.myweather.presenation.viewmodel.state.TodayForecastUiState
import com.android.myweather.presenation.viewmodel.state.WeatherUiState
import com.android.myweather.presenation.viewmodel.state.WeeklyForecastUiState

class WeatherMapper{
    fun mapWeatherToWeatherUiState(weather: Weather): WeatherUiState{
        return WeatherUiState(
            todayForecastUiState = getTodayForecastUiStatefromWeather(weather),
            hourlyForecastUiState = gethourlyForecastUiStatefromWeather(weather),
            weeklyForecastUiState = getweeklyForecastUiStatefromWeather(weather),
        )
    }
    
    private fun getTodayForecastUiStatefromWeather(weather: Weather): TodayForecastUiState{
        return TodayForecastUiState(
            temperature = weather.currentTemperature,
            forecast = weather.currentWeatherForecast.name,
            forecastImg = R.drawable.depositing_rime_fog_night,
            minTemp = weather.minTemperature,
            maxTemp = weather.maxTemperature,
            wind = weather.wind,
            humidity = weather.humidity,
            rain = weather.rain,
            uvIndex = weather.uvIndex,
            pressure = weather.pressure,
            feelLike = weather.feelsLike,
        )
    }

    private fun gethourlyForecastUiStatefromWeather(weather: Weather): List<HourlyForecastUiState> {
        val hourly = mutableListOf<HourlyForecastUiState>()
        
        for ( weather in weather.hourlyWeather){
            hourly.add(
                HourlyForecastUiState(
                    forecastImage = R.drawable.depositing_rime_fog_night,
                    temperatureDegree = weather.temperature.toString() + "°C",
                    hour = if(weather.hour < 10) "0" + weather.hour.toString() + ":00" else weather.hour.toString() + ":00"
                )
            )
        }
        return hourly
    }

    private fun getweeklyForecastUiStatefromWeather(weather: Weather): List<WeeklyForecastUiState> {
        val weekly = mutableListOf<WeeklyForecastUiState>()

        for ( weather in weather.weeklyWeather){
            weekly.add(
                WeeklyForecastUiState(
                    day = weather.day.name,
                    forecastImg = R.drawable.depositing_rime_fog_night,
                    minTemp = weather.minTemperature,
                    maxTemp = weather.maxTemperature
                )
            )
        }
        return weekly
    }
}