package com.android.myweather.presenation.screen

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.myweather.presenation.composable.CurrentLocationInfo
import com.android.myweather.presenation.composable.CurrentWeather
import com.android.myweather.presenation.composable.CurrentWeatherDetailsInfo
import com.android.myweather.presenation.composable.TodayForecast
import com.android.myweather.presenation.composable.WeeklyForecast
import com.android.myweather.presenation.viewmodel.WeatherViewModel
import com.android.myweather.ui.theme.lightBlue
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: WeatherViewModel = koinViewModel()){

    val weatherUiState = viewModel.weatherUiData.collectAsState().value
    val cityName = viewModel.cityName.collectAsState().value

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions.all { it.value }
        if (granted) {
            viewModel.getCurrentLocation()
        } else {
            viewModel.changeErrorMessage("Location permissions denied")
        }
    }

    LaunchedEffect(Unit) {
        if (viewModel.checkPermission()) {
            viewModel.getCurrentLocation()
        } else {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }


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
            cityName?.let { CurrentLocationInfo(Modifier.padding(top = 64.dp), it) }
            CurrentWeather(
                Modifier.padding(top = 76.dp),
                isScrolled,
                forecastImg = weatherUiState.todayForecastUiState.forecastImg,
                temperature = weatherUiState.todayForecastUiState.temperature,
                forecast = weatherUiState.todayForecastUiState.forecast,
                minTemp = weatherUiState.todayForecastUiState.minTemp,
                maxTemp = weatherUiState.todayForecastUiState.maxTemp
            )
        }
        CurrentWeatherDetailsInfo(
            wind = weatherUiState.todayForecastUiState.wind,
            rain = weatherUiState.todayForecastUiState.rain,
            feelsLike = weatherUiState.todayForecastUiState.feelLike,
            humidity = weatherUiState.todayForecastUiState.humidity,
            pressure = weatherUiState.todayForecastUiState.pressure,
            uv_index = weatherUiState.todayForecastUiState.uvIndex
        )
        TodayForecast(forecastStates = weatherUiState.hourlyForecastUiState)
        WeeklyForecast(forecastStates = weatherUiState.weeklyForecastUiState)
    }
}

@Preview(heightDp = 800, widthDp = 360)
@Composable
private fun HomeScreenPreview(){
    HomeScreen()
}