package com.android.myweather.presenation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.android.myweather.presenation.viewmodel.state.WeeklyForecastUiState
import com.android.myweather.ui.theme.darkBlue24pre
import com.android.myweather.ui.theme.darkBlue60pre
import com.android.myweather.ui.theme.darkBlue87pre
import com.android.myweather.ui.theme.letterSpacing25
import com.android.myweather.ui.theme.text16
import com.android.myweather.ui.theme.urbanist

@Composable
fun WeeklyForecastItem(
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
            color = darkBlue60pre,
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
            modifier = Modifier.width(91.dp).height(45.dp)
        )
        Row (
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.align(Alignment.CenterVertically)
            ){
            MinMaxTemperature(painterResource(R.drawable.arrow_up),"${weeklyForecastUiState.maxTemp}°C", darkBlue87pre, darkBlue87pre)
            VerticalDivider(color = darkBlue24pre, modifier = Modifier.height(19.dp))
            MinMaxTemperature(painterResource(R.drawable.arrow_down),"${weeklyForecastUiState.minTemp}°C", darkBlue87pre, darkBlue87pre)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeeklyForecastItemPreview(){
    WeeklyForecastItem()
}