package com.android.myweather.presenation.viewmodel.state

import com.android.myweather.R

data class WeeklyForecastUiState(
    val day: String = "",
    val forecastImg: Int = R.drawable.fog_day,
    val minTemp: Int = 0,
    val maxTemp: Int = 0
)