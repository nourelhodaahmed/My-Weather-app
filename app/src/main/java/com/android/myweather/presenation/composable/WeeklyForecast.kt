package com.android.myweather.presenation.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.android.myweather.presenation.viewmodel.state.WeeklyForecastUiState
import com.android.myweather.ui.theme.ThemeColor
import com.android.myweather.ui.theme.letterSpacing25
import com.android.myweather.ui.theme.text20
import com.android.myweather.ui.theme.urbanist

@Composable
fun WeeklyForecast(
    themeColor: ThemeColor,
    forecastStates: List<WeeklyForecastUiState>
){
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .padding(bottom = 32.dp)

    ) {
        Text(
            text = "Next 7 days",
            color = themeColor.HeaderDarkBlue,
            fontSize = text20,
            letterSpacing = letterSpacing25,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.W600,
            fontFamily = urbanist,
        )
        Spacer(Modifier.height(12.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = themeColor.boxBackgroundwhite70pre),
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .clip(RoundedCornerShape(24.dp))
                .border(width = 1.dp, color = themeColor.ButtonsdarkBlue8pre, shape = RoundedCornerShape(24.dp))
        ){
            for(forecast in 0..(forecastStates.size - 1)){
                WeeklyForecastItem(themeColor, weeklyForecastUiState = forecastStates[forecast])
                if (forecast != forecastStates.size - 1){
                    HorizontalDivider(color = themeColor.ButtonsdarkBlue8pre)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeeklyForecastPreview(){
    WeeklyForecast(
        ThemeColor(
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
        ),
        listOf(
            WeeklyForecastUiState(
                day = "Monday",
                forecastImg = R.drawable.weather_icon,
                minTemp = 20,
                maxTemp = 32
            ),
            WeeklyForecastUiState(
                day = "Monday",
                forecastImg = R.drawable.weather_icon,
                minTemp = 20,
                maxTemp = 32
            ),
            WeeklyForecastUiState(
                day = "Monday",
                forecastImg = R.drawable.weather_icon,
                minTemp = 20,
                maxTemp = 32
            ),
            WeeklyForecastUiState(
                day = "Monday",
                forecastImg = R.drawable.weather_icon,
                minTemp = 20,
                maxTemp = 32
            ),
            WeeklyForecastUiState(
                day = "Monday",
                forecastImg = R.drawable.weather_icon,
                minTemp = 20,
                maxTemp = 32
            ),
            WeeklyForecastUiState(
                day = "Monday",
                forecastImg = R.drawable.weather_icon,
                minTemp = 20,
                maxTemp = 32
            ),
        )
    )
}