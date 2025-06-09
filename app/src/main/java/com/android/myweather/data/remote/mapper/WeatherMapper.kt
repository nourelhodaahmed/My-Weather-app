package com.android.myweather.data.remote.mapper

import com.android.myweather.data.remote.model.Daily
import com.android.myweather.data.remote.model.Hourly
import com.android.myweather.data.remote.model.WeatherDto
import com.android.myweather.domain.model.DailyWeather
import com.android.myweather.domain.model.Day
import com.android.myweather.domain.model.HourlyWeather
import com.android.myweather.domain.model.Weather
import com.android.myweather.domain.model.WeatherForecast
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WeatherMapper{
    fun mapDtoToWeather(weatherDto: WeatherDto): Weather{
        return Weather(
            currentTemperature = weatherDto.current.temperature2m.toInt(),
            currentWeatherForecast = getWeatherForeCast(weatherDto.current.weatherCode),
            minTemperature = weatherDto.daily.temperature2mMin[0].toInt(),
            maxTemperature = weatherDto.daily.temperature2mMax[0].toInt(),
            wind = weatherDto.current.windSpeed10m.toInt(),
            humidity = weatherDto.current.relativeHumidity2m,
            rain = weatherDto.current.precipitationProbability,
            uvIndex = weatherDto.current.uvIndex.toInt(),
            pressure = weatherDto.current.pressureMsl.toInt(),
            feelsLike = weatherDto.current.apparentTemperature.toInt(),
            hourlyWeather = getHourlyWeather(weatherDto.hourly),
            weeklyWeather = getWeeklyWeather(weatherDto.daily),
        )
    }
    private fun getHourlyWeather(hourly: Hourly): List<HourlyWeather>{
        val hourlyWeather = mutableListOf<HourlyWeather>()
        for ( index in 0..< hourly.time.size){
            val date = LocalDateTime.parse(hourly.time[index], DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"))
            if (date.dayOfMonth == LocalDate.now().dayOfMonth){
                hourlyWeather.add(
                    HourlyWeather(
                        hour = date.hour,
                        weatherForecast = getWeatherForeCast(hourly.weatherCode[index]),
                        temperature = hourly.temperature2m[index].toInt()
                    )
                )
            }
        }
        return hourlyWeather
    }

    private fun getWeeklyWeather(daily: Daily): List<DailyWeather>{
        val dailyWeather = mutableListOf<DailyWeather>()
        for (index in 0..< daily.time.size){
            val date = LocalDate.parse(daily.time[index], DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            dailyWeather.add(
                DailyWeather(
                    weatherForecast = getWeatherForeCast(daily.weatherCode[index]),
                    day = Day.valueOf(date.dayOfWeek.name),
                    maxTemperature = daily.temperature2mMax[index].toInt(),
                    minTemperature = daily.temperature2mMin[index].toInt()
                )
            )
        }
        return dailyWeather
    }

    private fun getWeatherForeCast(weatherCode: Int): WeatherForecast {
        return when (weatherCode) {
            0 -> WeatherForecast.CLEAR_SKY
            1 -> WeatherForecast.MAINLY_CLEAR
            2 -> WeatherForecast.PARTLY_CLOUDY
            3 -> WeatherForecast.OVERCAST
            45 -> WeatherForecast.FOG
            48 -> WeatherForecast.DEPOSITING_RIME_FOG
            51 -> WeatherForecast.DRIZZLE_LIGHT
            53 -> WeatherForecast.DRIZZLE_MODERATE
            55 -> WeatherForecast.DRIZZLE_HIGH
            56 -> WeatherForecast.FREEZING_DRIZZLE_LIGHT
            57 -> WeatherForecast.FREEZING_DRIZZLE_HIGH
            61 -> WeatherForecast.RAIN_LIGHT
            63 -> WeatherForecast.RAIN_MODERATE
            65 -> WeatherForecast.RAIN_HEAVY
            66 -> WeatherForecast.FREEZING_RAIN_LIGHT
            67 -> WeatherForecast.FREEZING_RAIN_HIGH
            73 -> WeatherForecast.SNOW_MODERATE
            71 -> WeatherForecast.SNOW_LIGHT
            75 -> WeatherForecast.SNOW_HEAVY
            77 -> WeatherForecast.SNOW_GRAINS
            80 -> WeatherForecast.RAIN_SHOWER_LIGHT
            81 -> WeatherForecast.RAIN_SHOWER_MODERATE
            82 -> WeatherForecast.RAIN_SHOWER_HEAVY
            85 -> WeatherForecast.SNOW_SHOWER_LIGHT
            86 -> WeatherForecast.SNOW_SHOWER_HEAVY
            95 -> WeatherForecast.THUNDER_STORM
            96 -> WeatherForecast.THUNDER_STORM_HAIL_LIGHT
            99 -> WeatherForecast.THUNDER_STORM_HAIL_HEAVY
            else -> WeatherForecast.UNKNOWN_WEATHER_FORECAST
        }
    }
}
