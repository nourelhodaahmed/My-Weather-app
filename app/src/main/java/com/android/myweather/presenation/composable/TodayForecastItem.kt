package com.android.myweather.presenation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.android.myweather.presenation.viewmodel.state.TodayForecastUiState
import com.android.myweather.ui.theme.darkBlue60pre
import com.android.myweather.ui.theme.darkBlue87pre
import com.android.myweather.ui.theme.darkBlue8pre
import com.android.myweather.ui.theme.letterSpacing25
import com.android.myweather.ui.theme.text16
import com.android.myweather.ui.theme.urbanist
import com.android.myweather.ui.theme.white70pre

@Composable
fun TodayForeCastItem(
    todayForecastUiState: TodayForecastUiState = TodayForecastUiState(
        forecastImage = painterResource(R.drawable.weather_icon),
        temperatureDegree = "25°C",
        hour = "11:00"
    )
){
    Box(
        modifier = Modifier
            .width(88.dp)
    ){
        Card(
            colors = CardDefaults.cardColors(containerColor = white70pre),
            modifier = Modifier
                .width(88.dp)
                .padding(top = 12.dp)
                .height(120.dp)
                .clip(RoundedCornerShape(20.dp))
                .border(width = 1.dp, color = darkBlue8pre, shape = RoundedCornerShape(20.dp))
        ){}
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Image(
                painter = todayForecastUiState.forecastImage,
                contentDescription = null,
                modifier = Modifier.width(64.dp).height(58.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = todayForecastUiState.temperatureDegree,
                color = darkBlue87pre,
                fontSize = text16,
                letterSpacing = letterSpacing25,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W500,
                fontFamily = urbanist,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = todayForecastUiState.hour,
                color = darkBlue60pre,
                fontSize = text16,
                letterSpacing = letterSpacing25,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W500,
                fontFamily = urbanist,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TodayForeCastItemPreview(){
    TodayForeCastItem()
}