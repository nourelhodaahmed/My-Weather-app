package com.android.myweather.presenation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.android.myweather.presenation.viewmodel.state.WeeklyForecastUiState
import com.android.myweather.ui.theme.ThemeColor
import com.android.myweather.ui.theme.verticaldarkBlue24pre
import com.android.myweather.ui.theme.letterSpacing25
import com.android.myweather.ui.theme.text16
import com.android.myweather.ui.theme.urbanist

@Composable
fun WeeklyForecastItem(
    themeColor: ThemeColor,
    weeklyForecastUiState: WeeklyForecastUiState = WeeklyForecastUiState(
        day = "Monday",
        forecastImg = R.drawable.weather_icon,
        minTemp = 20,
        maxTemp = 32
    )
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = weeklyForecastUiState.day,
            color = themeColor.contentDarkBlue60pre,
            fontSize = text16,
            letterSpacing = letterSpacing25,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.W400,
            fontFamily = urbanist,
            modifier = Modifier.width(91.dp).align(Alignment.CenterVertically)
        )
        Image(
            painter = painterResource(weeklyForecastUiState.forecastImg),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
        Row (
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.align(Alignment.CenterVertically)
            ){
            MinMaxTemperature(painterResource(R.drawable.arrow_up),"${weeklyForecastUiState.maxTemp}°C", themeColor.header2darkBlue87pre, themeColor.header2darkBlue87pre)
            VerticalDivider(color = verticaldarkBlue24pre, modifier = Modifier.height(19.dp))
            MinMaxTemperature(painterResource(R.drawable.arrow_down),"${weeklyForecastUiState.minTemp}°C", themeColor.header2darkBlue87pre, themeColor.header2darkBlue87pre)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeeklyForecastItemPreview(){
    WeeklyForecastItem(ThemeColor(
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