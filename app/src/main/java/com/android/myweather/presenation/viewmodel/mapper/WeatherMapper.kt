package com.android.myweather.presenation.viewmodel.mapper

import com.android.myweather.R
import com.android.myweather.domain.model.Weather
import com.android.myweather.domain.model.WeatherForecast
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
            forecastImg = getForecastImage(weatherForecast = weather.currentWeatherForecast, isDay = weather.isDay),
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
        
        for ( hourweather in weather.hourlyWeather){
            hourly.add(
                HourlyForecastUiState(
                    forecastImage = getForecastImage(weatherForecast = hourweather.weatherForecast, isDay = weather.isDay),
                    temperatureDegree = hourweather.temperature.toString() + "°C",
                    hour = if(hourweather.hour < 10) "0" + hourweather.hour.toString() + ":00" else hourweather.hour.toString() + ":00"
                )
            )
        }
        return hourly
    }

    private fun getweeklyForecastUiStatefromWeather(weather: Weather): List<WeeklyForecastUiState> {
        val weekly = mutableListOf<WeeklyForecastUiState>()

        for ( weekweather in weather.weeklyWeather){
            weekly.add(
                WeeklyForecastUiState(
                    day = weekweather.day.name,
                    forecastImg = getForecastImage(weatherForecast = weekweather.weatherForecast, isDay = weather.isDay),
                    minTemp = weekweather.minTemperature,
                    maxTemp = weekweather.maxTemperature
                )
            )
        }
        return weekly
    }

    private fun getForecastImage(isDay: Boolean, weatherForecast: WeatherForecast): Int{

        return when(weatherForecast){
            WeatherForecast.CLEAR_SKY -> { if (isDay) R.drawable.clear_sky_day else R.drawable.clear_sky_night }
            WeatherForecast.DEPOSITING_RIME_FOG -> { if (isDay) R.drawable.depositing_rime_fog_day else R.drawable.depositing_rime_fog_night }
            WeatherForecast.DRIZZLE_LIGHT -> { if (isDay) R.drawable.drizzle_light_day else R.drawable.drizzle_light_night }
            WeatherForecast.DRIZZLE_HIGH -> { if (isDay) R.drawable.drizzle_intensity_day else R.drawable.drizzle_intensity_night }
            WeatherForecast.DRIZZLE_MODERATE -> { if (isDay) R.drawable.drizzle_moderate_day else R.drawable.drizzle_moderate_night }
            WeatherForecast.FOG -> { if (isDay) R.drawable.fog_day else R.drawable.fog_night }
            WeatherForecast.FREEZING_DRIZZLE_LIGHT -> { if (isDay) R.drawable.freezing_drizzle_light_day else R.drawable.freezing_drizzle_light_night }
            WeatherForecast.FREEZING_DRIZZLE_HIGH -> { if (isDay) R.drawable.freezing_drizzle_intensity_day else R.drawable.freezing_drizzle_intensity_night }
            WeatherForecast.FREEZING_RAIN_LIGHT -> { if (isDay) R.drawable.freezing_loght_day else R.drawable.freezing_light_night }
            WeatherForecast.FREEZING_RAIN_HIGH -> { if (isDay) R.drawable.freezing_heavy_day else R.drawable.freezing_heavy_night }
            WeatherForecast.MAINLY_CLEAR -> { if (isDay) R.drawable.mainly_clear_day else R.drawable.mainly_clear_night }
            WeatherForecast.OVERCAST -> { if (isDay) R.drawable.overcast_day else R.drawable.overcast_night }
            WeatherForecast.PARTLY_CLOUDY -> { if (isDay) R.drawable.partly_cloudy_day else R.drawable.partly_cloudy_night }
            WeatherForecast.RAIN_LIGHT -> { if (isDay) R.drawable.rain_slight_day else R.drawable.rain_slight_night }
            WeatherForecast.RAIN_SHOWER_LIGHT -> { if (isDay) R.drawable.rain_shower_slight_day else R.drawable.rain_slight_night }
            WeatherForecast.RAIN_SHOWER_MODERATE -> { if (isDay) R.drawable.rain_shower_moderate_day else R.drawable.rain_shower_moderate_day }
            WeatherForecast.RAIN_SHOWER_HEAVY -> { if (isDay) R.drawable.rain_shower_violent_day else R.drawable.rain_shower_violent_day }
            WeatherForecast.SNOW_LIGHT -> { if (isDay) R.drawable.snow_fall_light_day else R.drawable.snow_fall_light_night }
            WeatherForecast.SNOW_MODERATE -> { if (isDay) R.drawable.snow_fall_moderate_day else R.drawable.snow_fall_moderate_night }
            WeatherForecast.SNOW_HEAVY -> { if (isDay) R.drawable.snow_fall_intensity_day else R.drawable.snow_fall_intensity_night }
            WeatherForecast.SNOW_GRAINS -> { if (isDay) R.drawable.snow_grains_day else R.drawable.snow_grains_night }
            WeatherForecast.SNOW_SHOWER_LIGHT -> { if (isDay) R.drawable.snow_shower_slight_day else R.drawable.snow_shower_slight_night }
            WeatherForecast.SNOW_SHOWER_HEAVY -> { if (isDay) R.drawable.snow_shower_heavy_day else R.drawable.snow_shower_heavy_night }
            WeatherForecast.THUNDER_STORM_HAIL_HEAVY -> { if (isDay) R.drawable.thunderstrom_with_heavy_hail_day else R.drawable.thunderstrom_with_heavy_hail_night }
            WeatherForecast.THUNDER_STORM_HAIL_LIGHT -> { if (isDay) R.drawable.thunderstrom_with_slight_hail_day else R.drawable.thunderstrom_with_slight_hail_night }
            WeatherForecast.THUNDER_STORM -> { if (isDay) R.drawable.thunderstrom_slight_or_moderate_day else R.drawable.thunderstrom_slight_or_moderate_night }
            else -> { if (isDay) R.drawable.thunderstrom_with_heavy_hail_day else R.drawable.thunderstrom_with_heavy_hail_night }

        }
    }
}