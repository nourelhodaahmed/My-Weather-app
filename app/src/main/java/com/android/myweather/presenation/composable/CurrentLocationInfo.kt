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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.myweather.R
import com.android.myweather.ui.theme.ThemeColor
import com.android.myweather.ui.theme.letterSpacing25
import com.android.myweather.ui.theme.text16
import com.android.myweather.ui.theme.urbanist

@Composable
fun CurrentLocationInfo(
    modifier: Modifier = Modifier,
    cityName: String = "Baghdad",
    theme: ThemeColor
){
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
    ){
        Icon(
            painter = painterResource(R.drawable.location),
            contentDescription = null,
            tint = theme.IcondarkRed,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = cityName ,
            color = theme.IcondarkRed,
            fontSize = text16,
            letterSpacing = letterSpacing25,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.W500,
            fontFamily = urbanist,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CurrentLocationInfoPreview(){
    CurrentLocationInfo(theme = ThemeColor(
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