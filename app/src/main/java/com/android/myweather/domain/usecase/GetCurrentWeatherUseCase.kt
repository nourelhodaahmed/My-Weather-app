package com.android.myweather.domain.usecase

import com.android.myweather.domain.model.Weather
import com.android.myweather.domain.repository.WeatherRepository

class GetCurrentWeatherUseCase(val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(lat: Double, long: Double): Weather{
        return weatherRepository.getWeatherByCoordinate(lat, long)
    }
}