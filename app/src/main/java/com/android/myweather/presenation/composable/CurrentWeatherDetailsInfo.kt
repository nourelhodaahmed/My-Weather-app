package com.android.myweather.presenation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.myweather.R

@Composable
fun CurrentWeatherDetailsInfo(
    wind: Int = 13,
    humidity: Int = 24,
    rain: Int = 2,
    uv_index: Int = 2,
    pressure: Int = 1012,
    feelsLike: Int = 22,
){
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ){
            WeatherDetailsInfoItem(
                icon = painterResource(R.drawable.wind),
                value = wind.toString() + " KM/h",
                name = "Wind"
            )
            WeatherDetailsInfoItem(
                icon = painterResource(R.drawable.humidity),
                value = humidity.toString() + "%",
                name = "Humidity"
            )
            WeatherDetailsInfoItem(
                icon = painterResource(R.drawable.rain),
                value = rain.toString() + "%",
                name = "Rain"
            )
        }
        Row (
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ){
            WeatherDetailsInfoItem(
                icon = painterResource(R.drawable.uv_index),
                value = uv_index.toString(),
                name = "UV Index"
            )
            WeatherDetailsInfoItem(
                icon = painterResource(R.drawable.pressure),
                value = pressure.toString() + " hPa",
                name = "Pressure"
            )
            WeatherDetailsInfoItem(
                icon = painterResource(R.drawable.feels_like),
                value = feelsLike.toString() + "°C",
                name = "Feels like"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CurrentWeatherDetailsInfoPreview(){
    CurrentWeatherDetailsInfo()
}