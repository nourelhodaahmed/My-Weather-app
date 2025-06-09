package com.android.myweather.presenation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.android.myweather.ui.theme.Blue32pre

@Composable
fun CurrentWeatherIcon(
    parentModifier: Modifier,
    imageModifier: Modifier = Modifier
        .padding(top = 24.dp, start = 30.dp, bottom = 26.dp)
        .height(200.dp)
        .width(220.21.dp),
    blurModifier: Modifier = Modifier.size(250.dp)
    ){
    Box (
        modifier = parentModifier
    ){
        Box(
            modifier = blurModifier
                .clip(CircleShape)
                .blur(150.dp)
        ){
            Box(
                modifier = blurModifier
                    .clip(CircleShape)
                    .blur(150.dp)
                    .background(Blue32pre, shape = CircleShape)
            )
        }
        Image(
            painter = painterResource(R.drawable.weather_icon),
            contentDescription = null,
            modifier = imageModifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CurrentWeatherIconPreview(){
    CurrentWeatherIcon(parentModifier = Modifier)
}