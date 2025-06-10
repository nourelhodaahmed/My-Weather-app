package com.android.myweather.presenation.viewmodel.state

data class WeatherUiState(
    val todayForecastUiState: TodayForecastUiState = TodayForecastUiState(),
    val hourlyForecastUiState: List<HourlyForecastUiState> = listOf(),
    val weeklyForecastUiState: List<WeeklyForecastUiState> = listOf()
)