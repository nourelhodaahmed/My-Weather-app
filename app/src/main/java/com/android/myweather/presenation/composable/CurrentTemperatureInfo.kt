package com.android.myweather.presenation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.android.myweather.ui.theme.verticaldarkBlue24pre
import com.android.myweather.ui.theme.ButtonsdarkBlue8pre
import com.android.myweather.ui.theme.ThemeColor
import com.android.myweather.ui.theme.letterSpacing25
import com.android.myweather.ui.theme.text16
import com.android.myweather.ui.theme.text64
import com.android.myweather.ui.theme.urbanist

@Composable
fun CurrentTemperatureInfo(
    theme: ThemeColor,
    modifier: Modifier,
    temperature: Int = 24,
    forecast: String = "Partly cloudy",
    minTemp: Int = 20,
    maxTemp: Int = 32,
){
    Column (
        modifier = modifier
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = temperature.toString() + "°C",
                color = theme.HeaderDarkBlue,
                fontSize = text64,
                letterSpacing = letterSpacing25,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.W600,
                fontFamily = urbanist,
            )
            Text(
                text = forecast,
                color = theme.contentDarkBlue60pre,
                fontSize = text16,
                letterSpacing = letterSpacing25,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.W500,
                fontFamily = urbanist,
            )

        }
        Spacer(Modifier.height(12.dp))
        MinMaxButton(minTemp , maxTemp, theme)
    }
}

@Composable
private fun MinMaxButton(minTemp: Int = 20, maxTemp: Int = 32, theme: ThemeColor){
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .background(color = theme.ButtonsdarkBlue8pre, shape = RoundedCornerShape(100.dp))
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        MinMaxTemperature(painterResource(R.drawable.arrow_up),maxTemp.toString()+ "°C", theme.contentDarkBlue60pre, theme.contentDarkBlue60pre)
        VerticalDivider(color = verticaldarkBlue24pre, modifier = Modifier.height(19.dp))
        MinMaxTemperature(painterResource(R.drawable.arrow_down),minTemp.toString()+ "°C", theme.contentDarkBlue60pre, theme.contentDarkBlue60pre)
    }
}

@Preview(showBackground = true)
@Composable
private fun CurrentTemperatureInfoPreview(){
    CurrentTemperatureInfo(modifier = Modifier,
        theme = ThemeColor(
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
