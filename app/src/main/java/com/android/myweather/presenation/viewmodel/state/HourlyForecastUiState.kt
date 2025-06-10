package com.android.myweather.presenation.viewmodel.state

import com.android.myweather.R

data class HourlyForecastUiState(
    val forecastImage: Int = R.drawable.fog_day,
    val temperatureDegree: String = "",
    val hour: String = "",
)