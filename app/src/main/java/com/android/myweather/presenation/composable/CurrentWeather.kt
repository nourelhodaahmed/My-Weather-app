package com.android.myweather.presenation.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun CurrentWeather(){
    ConstraintLayout (
        modifier = Modifier.fillMaxWidth()
    ){
        val (weatherImg, weatherDetails) = createRefs()
        CurrentWeatherIcon(
            parentModifier = Modifier.constrainAs(weatherImg){
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            },
            imageModifier = Modifier
                .padding(top = 24.dp, start = 30.dp, bottom = 26.dp)
                .height(200.dp)
                .width(220.21.dp),
            blurModifier = Modifier.size(250.dp)
        )
        CurrentTemperatureInfo(
            Modifier.constrainAs(weatherDetails){
                top.linkTo(weatherImg.top, margin = 236.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CurrentWeatherPreview(){
    CurrentWeather()
}