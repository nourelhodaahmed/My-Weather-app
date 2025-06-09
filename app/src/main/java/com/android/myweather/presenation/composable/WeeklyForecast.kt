package com.android.myweather.presenation.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.android.myweather.presenation.viewmodel.state.WeeklyForecastUiState
import com.android.myweather.ui.theme.darkBlue
import com.android.myweather.ui.theme.darkBlue8pre
import com.android.myweather.ui.theme.letterSpacing25
import com.android.myweather.ui.theme.text20
import com.android.myweather.ui.theme.urbanist
import com.android.myweather.ui.theme.white70pre

@Composable
fun WeeklyForecast(
    forecastStates: List<WeeklyForecastUiState>
){
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .padding(bottom = 32.dp)

    ) {
        Text(
            text = "Next 7 days",
            color = darkBlue,
            fontSize = text20,
            letterSpacing = letterSpacing25,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.W600,
            fontFamily = urbanist,
        )
        Spacer(Modifier.height(12.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = white70pre),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .border(width = 1.dp, color = darkBlue8pre, shape = RoundedCornerShape(24.dp))
                .padding(4.dp)
        ){
            for(forecast in 0..(forecastStates.size - 1)){
                WeeklyForecastItem(weeklyForecastUiState = forecastStates[forecast])
                if (forecast != forecastStates.size - 1){
                    HorizontalDivider(color = darkBlue8pre)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeeklyForecastPreview(){
    WeeklyForecast(
        listOf(
            WeeklyForecastUiState(
                day = "Monday",
                forecastImg = painterResource(R.drawable.weather_icon),
                minTemp = 20,
                maxTemp = 32
            ),
            WeeklyForecastUiState(
                day = "Monday",
                forecastImg = painterResource(R.drawable.weather_icon),
                minTemp = 20,
                maxTemp = 32
            ),
            WeeklyForecastUiState(
                day = "Monday",
                forecastImg = painterResource(R.drawable.weather_icon),
                minTemp = 20,
                maxTemp = 32
            ),
            WeeklyForecastUiState(
                day = "Monday",
                forecastImg = painterResource(R.drawable.weather_icon),
                minTemp = 20,
                maxTemp = 32
            ),
            WeeklyForecastUiState(
                day = "Monday",
                forecastImg = painterResource(R.drawable.weather_icon),
                minTemp = 20,
                maxTemp = 32
            ),
            WeeklyForecastUiState(
                day = "Monday",
                forecastImg = painterResource(R.drawable.weather_icon),
                minTemp = 20,
                maxTemp = 32
            ),
        )
    )
}