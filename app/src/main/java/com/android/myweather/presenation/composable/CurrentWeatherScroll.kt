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
fun CurrentWeatherScroll(){
    ConstraintLayout (
        modifier = Modifier.fillMaxWidth()
    ){
        val (weatherImg, weatherDetails) = createRefs()
        CurrentWeatherIcon(
            parentModifier = Modifier.constrainAs(weatherImg){
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
                top.linkTo(parent.top)
            },
            imageModifier = Modifier
                .padding(top = 23.5.dp, start = 12.dp, bottom = 14.5.dp, end = 14.dp)
                .height(124.dp)
                .width(112.dp),
            blurModifier = Modifier.size(150.dp)
        )
        CurrentTemperatureInfo(
            Modifier.constrainAs(weatherDetails){
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CurrentWeatherScrollPreview(){
    CurrentWeatherScroll()
}