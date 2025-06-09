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
fun CurrentWeatherDetailsInfo(){
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ){
            WeatherDetailsInfoItem(
                icon = painterResource(R.drawable.wind),
                value = "13 KM/h",
                name = "Wind"
            )
            WeatherDetailsInfoItem(
                icon = painterResource(R.drawable.humidity),
                value = "24%",
                name = "Humidity"
            )
            WeatherDetailsInfoItem(
                icon = painterResource(R.drawable.rain),
                value = "2%",
                name = "Rain"
            )
        }
        Row (
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ){
            WeatherDetailsInfoItem(
                icon = painterResource(R.drawable.uv_index),
                value = "2",
                name = "UV Index"
            )
            WeatherDetailsInfoItem(
                icon = painterResource(R.drawable.pressure),
                value = "1012 hPa",
                name = "Pressure"
            )
            WeatherDetailsInfoItem(
                icon = painterResource(R.drawable.feels_like),
                value = "22°C",
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