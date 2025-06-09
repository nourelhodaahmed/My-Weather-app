package com.android.myweather.presenation.viewmodel.state

import androidx.compose.ui.graphics.painter.Painter

data class TodayForecastUiState(
    val forecastImage: Painter,
    val temperatureDegree: String,
    val hour: String,
)
