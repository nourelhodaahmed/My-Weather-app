package com.android.myweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.android.myweather.di.appModule
import com.android.myweather.presenation.screen.HomeScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            androidContext(this@MainActivity)
            modules(appModule)
        }
        enableEdgeToEdge()
        setContent {
            HomeScreen()
        }
    }
}