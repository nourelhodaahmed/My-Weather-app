package com.android.myweather.presenation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.android.myweather.presenation.viewmodel.state.HourlyForecastUiState
import com.android.myweather.ui.theme.ThemeColor
import com.android.myweather.ui.theme.header2darkBlue87pre
import com.android.myweather.ui.theme.letterSpacing25
import com.android.myweather.ui.theme.text20
import com.android.myweather.ui.theme.urbanist

@Composable
fun TodayForecast(
    theme: ThemeColor,
    forecastStates: List<HourlyForecastUiState>
){
    Column{
        Text(
            text = "Today",
            color = header2darkBlue87pre,
            fontSize = text20,
            letterSpacing = letterSpacing25,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.W600,
            fontFamily = urbanist,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
        Spacer(Modifier.height(24.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(forecastStates) {
                TodayForeCastItem(theme,hourlyForecastUiState = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TodayForecastPreview(){
    TodayForecast(
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
            HourlyForecastUiState(
                forecastImage = R.drawable.weather_icon,
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            HourlyForecastUiState(
                forecastImage = R.drawable.weather_icon,
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            HourlyForecastUiState(
                forecastImage = R.drawable.weather_icon,
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            HourlyForecastUiState(
                forecastImage = R.drawable.weather_icon,
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            HourlyForecastUiState(
                forecastImage = R.drawable.weather_icon,
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            HourlyForecastUiState(
                forecastImage = R.drawable.weather_icon,
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            HourlyForecastUiState(
                forecastImage = R.drawable.weather_icon,
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            HourlyForecastUiState(
                forecastImage = R.drawable.weather_icon,
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            HourlyForecastUiState(
                forecastImage = R.drawable.weather_icon,
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
        )
    )
}