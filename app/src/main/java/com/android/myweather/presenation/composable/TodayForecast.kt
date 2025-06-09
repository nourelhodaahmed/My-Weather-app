package com.android.myweather.presenation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.android.myweather.presenation.viewmodel.state.TodayForecastUiState
import com.android.myweather.ui.theme.darkBlue87pre
import com.android.myweather.ui.theme.letterSpacing25
import com.android.myweather.ui.theme.text20
import com.android.myweather.ui.theme.urbanist

@Composable
fun TodayForecast(
    forecastStates: List<TodayForecastUiState>
){
    Column {
        Text(
            text = "Today",
            color = darkBlue87pre,
            fontSize = text20,
            letterSpacing = letterSpacing25,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.W600,
            fontFamily = urbanist,
        )
        Spacer(Modifier.height(24.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
            //contentPadding = PaddingValues(horizontal = 12.dp)
        ) {
            items(forecastStates) {
                TodayForeCastItem(todayForecastUiState = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TodayForecastPreview(){
    TodayForecast(
        listOf(
            TodayForecastUiState(
                forecastImage = painterResource(R.drawable.weather_icon),
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            TodayForecastUiState(
                forecastImage = painterResource(R.drawable.weather_icon),
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            TodayForecastUiState(
                forecastImage = painterResource(R.drawable.weather_icon),
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            TodayForecastUiState(
                forecastImage = painterResource(R.drawable.weather_icon),
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            TodayForecastUiState(
                forecastImage = painterResource(R.drawable.weather_icon),
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            TodayForecastUiState(
                forecastImage = painterResource(R.drawable.weather_icon),
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            TodayForecastUiState(
                forecastImage = painterResource(R.drawable.weather_icon),
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            TodayForecastUiState(
                forecastImage = painterResource(R.drawable.weather_icon),
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
            TodayForecastUiState(
                forecastImage = painterResource(R.drawable.weather_icon),
                temperatureDegree = "25°C",
                hour = "11:00"
            ),
        )
    )
}