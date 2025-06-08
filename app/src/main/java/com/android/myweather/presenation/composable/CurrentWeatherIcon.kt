package com.android.myweather.presenation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.android.myweather.ui.theme.Blue32pre

@Composable
fun CurrentWeatherIcon(){
    Box (
        modifier = Modifier.size(250.dp)
    ){
        Box(
            modifier = Modifier
                .size(250.dp)
                .blur(150.dp)
                .clip(CircleShape)
                .align(Alignment.TopCenter)
        ){
            Box(
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape)
                    .background(Blue32pre, shape = CircleShape)
            )
        }

        Image(
            painter = painterResource(R.drawable.weather_icon),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .width(220.21.dp)
                .align(Alignment.CenterEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CurrentWeatherIconPreview(){
    CurrentWeatherIcon()
}