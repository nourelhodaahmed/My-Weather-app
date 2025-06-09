package com.android.myweather.presenation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.android.myweather.ui.theme.darkBlue60pre
import com.android.myweather.ui.theme.darkBlue87pre
import com.android.myweather.ui.theme.darkBlue8pre
import com.android.myweather.ui.theme.letterSpacing25
import com.android.myweather.ui.theme.lightBlue
import com.android.myweather.ui.theme.text14
import com.android.myweather.ui.theme.text20
import com.android.myweather.ui.theme.urbanist
import com.android.myweather.ui.theme.white70pre

@Composable
fun WeatherDetailsInfoItem(
    icon: Painter = painterResource(R.drawable.wind),
    value: String = "13 KM/h",
    name: String = "Wind"
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(108.dp)
            .clip(RoundedCornerShape(24.dp))
            .border(width = 1.dp, color = darkBlue8pre, shape = RoundedCornerShape(24.dp))
            .background(color = white70pre, shape = RoundedCornerShape(24.dp))
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
        ){
            Icon(
                painter = icon,
                contentDescription = null,
                tint = lightBlue,
                modifier = Modifier.size(32.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = value,
                color = darkBlue87pre,
                fontSize = text20,
                letterSpacing = letterSpacing25,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W500,
                fontFamily = urbanist,
            )
            Text(
                text = name,
                color = darkBlue60pre,
                fontSize = text14,
                letterSpacing = letterSpacing25,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W400,
                fontFamily = urbanist,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeatherDetailsInfoPreview(){
    WeatherDetailsInfoItem()
}