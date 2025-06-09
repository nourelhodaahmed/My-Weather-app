package com.android.myweather.presenation.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import com.android.myweather.R
import com.android.myweather.presenation.composable.CurrentLocationInfo
import com.android.myweather.presenation.composable.CurrentWeather
import com.android.myweather.presenation.composable.CurrentWeatherDetailsInfo
import com.android.myweather.presenation.composable.TodayForecast
import com.android.myweather.presenation.composable.WeeklyForecast
import com.android.myweather.presenation.viewmodel.state.TodayForecastUiState
import com.android.myweather.presenation.viewmodel.state.WeeklyForecastUiState
import com.android.myweather.ui.theme.lightBlue

@OptIn(ExperimentalMotionApi::class)
@Composable
fun HomeScreen(){
    val scrollState = rememberScrollState()
    val isScrolled = scrollState.value > 1

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .background(brush = Brush.linearGradient(listOf(lightBlue, White)))
            .verticalScroll(scrollState)
    ) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.padding(horizontal = 12.dp)
        ){
            CurrentLocationInfo(Modifier.padding(top = 64.dp))
            CurrentWeather(Modifier.padding(top = 76.dp), isScrolled)
        }
        CurrentWeatherDetailsInfo()
        TodayForecast(
            listOf(
                TodayForecastUiState(
                    forecastImage = painterResource(R.drawable.weather_icon),
                    temperatureDegree = "25°C",
                    hour = "11:00"
                ),
                TodayForecastUiState(
                    forecastImage = painterResource(R.drawable.weather_icon),
                    temperatureDegree = "25°C",
                    hour = "11:00"
                ),
                TodayForecastUiState(
                    forecastImage = painterResource(R.drawable.weather_icon),
                    temperatureDegree = "25°C",
                    hour = "11:00"
                ),
                TodayForecastUiState(
                    forecastImage = painterResource(R.drawable.weather_icon),
                    temperatureDegree = "25°C",
                    hour = "11:00"
                ),
                TodayForecastUiState(
                    forecastImage = painterResource(R.drawable.weather_icon),
                    temperatureDegree = "25°C",
                    hour = "11:00"
                ),
                TodayForecastUiState(
                    forecastImage = painterResource(R.drawable.weather_icon),
                    temperatureDegree = "25°C",
                    hour = "11:00"
                ),
                TodayForecastUiState(
                    forecastImage = painterResource(R.drawable.weather_icon),
                    temperatureDegree = "25°C",
                    hour = "11:00"
                ),
                TodayForecastUiState(
                    forecastImage = painterResource(R.drawable.weather_icon),
                    temperatureDegree = "25°C",
                    hour = "11:00"
                ),
                TodayForecastUiState(
                    forecastImage = painterResource(R.drawable.weather_icon),
                    temperatureDegree = "25°C",
                    hour = "11:00"
                ),
            )
        )
        WeeklyForecast(
            forecastStates = listOf(
                WeeklyForecastUiState(
                    day = "Monday",
                    forecastImg = painterResource(R.drawable.weather_icon),
                    minTemp = 20,
                    maxTemp = 32
                ),
                WeeklyForecastUiState(
                    day = "Monday",
                    forecastImg = painterResource(R.drawable.weather_icon),
                    minTemp = 20,
                    maxTemp = 32
                ),
                WeeklyForecastUiState(
                    day = "Monday",
                    forecastImg = painterResource(R.drawable.weather_icon),
                    minTemp = 20,
                    maxTemp = 32
                ),
                WeeklyForecastUiState(
                    day = "Monday",
                    forecastImg = painterResource(R.drawable.weather_icon),
                    minTemp = 20,
                    maxTemp = 32
                ),
                WeeklyForecastUiState(
                    day = "Monday",
                    forecastImg = painterResource(R.drawable.weather_icon),
                    minTemp = 20,
                    maxTemp = 32
                ),
                WeeklyForecastUiState(
                    day = "Monday",
                    forecastImg = painterResource(R.drawable.weather_icon),
                    minTemp = 20,
                    maxTemp = 32
                ),
            )
        )
    }
}

@Preview(heightDp = 800, widthDp = 360)
@Composable
private fun HomeScreenPreview(){
    HomeScreen()
}