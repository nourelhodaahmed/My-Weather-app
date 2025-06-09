package com.android.myweather.domain.repository

import com.android.myweather.domain.model.Weather

interface WeatherRepository{
    suspend fun getWeatherByCoordinate( lat: Double, long: Double): Weather
}
