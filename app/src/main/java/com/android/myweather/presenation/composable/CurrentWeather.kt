package com.android.myweather.presenation.composable

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.android.myweather.ui.theme.ThemeColor

@Composable
fun CurrentWeather(
    modifier: Modifier = Modifier,
    isScrolled: Boolean = false,
    theme: ThemeColor,
    temperature: Int = 24,
    forecast: String = "Partly cloudy",
    forecastImg: Int = R.drawable.weather_icon,
    minTemp: Int = 20,
    maxTemp: Int = 32,
){
    Box(
        modifier = modifier
    ){
        val perantPaddingTop: Dp by animateDpAsState(if(isScrolled) 15.5.dp else 0.dp)
        val perantPaddingBottom: Dp by animateDpAsState(if(isScrolled) 15.5.dp else 0.dp)

        val blurSize: Dp by animateDpAsState(if(isScrolled) 150.dp else 250.dp)

        val imageHeight: Dp by animateDpAsState(if(isScrolled) 124.dp else 200.dp)
        val imageWidth: Dp by animateDpAsState(if(isScrolled) 112.dp else 220.21.dp)
        val imagePaddingTop: Dp by animateDpAsState(if(isScrolled) 23.5.dp else 24.dp)
        val imagePaddingBottom: Dp by animateDpAsState(if(isScrolled) 14.5.dp else 26.dp)
        val imagePaddingStart: Dp by animateDpAsState(if(isScrolled) 12.dp else 30.dp)
        val imagePaddingEnd: Dp by animateDpAsState(if(isScrolled) 14.dp else 0.dp)

        val tempInfoPaddingTop: Dp by animateDpAsState(if(isScrolled) 23.5.dp else 236.dp)
        val tempInfoPaddingStart: Dp by animateDpAsState(if(isScrolled) 150.dp else 0.dp)
        val tempInfoPaddingBottom: Dp by animateDpAsState(if(isScrolled) 14.5.dp else 0.dp)

        CurrentWeatherIcon(
            theme,
            parentModifier = Modifier.padding(top = perantPaddingTop, bottom = perantPaddingBottom).size(blurSize),
            imageModifier = Modifier
                .padding(top = imagePaddingTop, start = imagePaddingStart, bottom = imagePaddingBottom, end = imagePaddingEnd)
                .height(imageHeight)
                .width(imageWidth),
            blurModifier = Modifier.size(blurSize),
            forecastImage = forecastImg
        )
        CurrentTemperatureInfo(
            theme,
            modifier = Modifier.padding(top = tempInfoPaddingTop, start = tempInfoPaddingStart, bottom = tempInfoPaddingBottom).align(Alignment.BottomCenter),
            temperature = temperature,
            forecast = forecast,
            minTemp = minTemp,
            maxTemp = maxTemp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CurrentWeatherPreview(){
    CurrentWeather(isScrolled = true, theme = ThemeColor(
        backgroundLightBlue = Color(0xFF87CEFA),
        background2 = Color(0xFFFFFFFF),
        HeaderDarkBlue = Color(0xFF060414),
        BlurBlue32pre = Color(0x5200619D),
        IcondarkRed = Color(0xFF323232),
        boxBackgroundwhite70pre = Color(0xB3FFFFFF),
        contentDarkBlue60pre = Color(0x99060414),
        ButtonsdarkBlue8pre = Color(0x14060414),
        verticaldarkBlue24pre = Color(0x3D060414),
        header2darkBlue87pre = Color(0xDE060414)
    ))
}