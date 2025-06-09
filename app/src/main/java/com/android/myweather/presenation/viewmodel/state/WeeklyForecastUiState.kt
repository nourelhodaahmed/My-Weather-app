package com.android.myweather.presenation.viewmodel.state

import androidx.compose.ui.graphics.painter.Painter

data class WeeklyForecastUiState(
    val day: String,
    val forecastImg: Painter,
    val minTemp: Int,
    val maxTemp: Int
)
