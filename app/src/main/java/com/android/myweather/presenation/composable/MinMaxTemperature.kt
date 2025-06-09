package com.android.myweather.presenation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.android.myweather.ui.theme.darkBlue60pre
import com.android.myweather.ui.theme.letterSpacing25
import com.android.myweather.ui.theme.text16
import com.android.myweather.ui.theme.urbanist

@Composable
fun MinMaxTemperature(icon: Painter, text: String, iconColor: Color, textColor: Color){
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.size(12.dp).align(Alignment.CenterVertically)
        )
        Text(
            text = text,
            color = textColor,
            fontSize = text16,
            letterSpacing = letterSpacing25,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.W500,
            fontFamily = urbanist,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MinMaxTemperaturePreview(){
    MinMaxTemperature(painterResource(R.drawable.arrow_up),"32°C", darkBlue60pre, darkBlue60pre)
}