package com.android.myweather.presenation.screen

import android.Manifest
import android.app.AlertDialog
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.android.myweather.domain.model.Location
import com.android.myweather.domain.model.Weather
import com.android.myweather.presenation.viewmodel.WeatherViewModel
import io.ktor.websocket.Frame
import org.koin.androidx.compose.koinViewModel
import androidx.compose.ui.Alignment.Companion as Alignment1

@Composable
fun testScreen(viewModel: WeatherViewModel = koinViewModel()) {
    val context = LocalContext.current
    val location = viewModel.locationData.collectAsState().value
    val weather = viewModel.weatherData.collectAsState().value
    val showLocationSettings = viewModel.showLocationSettings.collectAsState().value
    val errorMessage = viewModel.errorMessage.collectAsState().value

    // Permission launcher
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions.all { it.value }
        if (granted) {
            viewModel.getCurrentLocation()
        } else {
            viewModel.changeErrorMessage("Location permissions denied")
        }
    }

    // Trigger permission request or location fetch
    LaunchedEffect(Unit) {
        if (viewModel.checkPermission()) {
            viewModel.getCurrentLocation()
        } else {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

    // Handle location settings prompt
    if (showLocationSettings) {
        // Show dialog or navigate to settings
        // Example: Show a dialog to prompt enabling location services
       /* AlertDialog(
            onDismissRequest = { viewModel.resetLocationSettingsPrompt() },
            title = { Text("Enable Location") },
            text = { Text("Please enable location services to get weather data.") },
            confirmButton = {
                Button(onClick = {
                    context.startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                    viewModel.resetLocationSettingsPrompt()
                }) {
                    Text("Go to Settings")
                }
            },
            dismissButton = {
                Button(onClick = { viewModel.resetLocationSettingsPrompt() }) {
                    Text("Cancel")
                }
            }
        )*/
    }

    // Handle error message
    errorMessage?.let {
        /*AlertDialog(
            onDismissRequest = { viewModel.resetErrorMessage() },
            title = { Text("Error") },
            text = { Text(it) },
            confirmButton = {
                Button(onClick = { viewModel.resetErrorMessage() }) {
                    Text("OK")
                }
            }
        )*/
    }

    // Display weather data
    WeatherContent(location = location, weather = weather)
}

@Composable
fun WeatherContent(location: Location?, weather: Weather?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment1.CenterHorizontally
    ) {
        location?.let {
            Frame.Text("City: ${it.city}")
            Text("Latitude: ${it.latitude}")
            Text("Longitude: ${it.longitude}")
        }
        weather?.let {
            Text("Temperature: ${it.currentTemperature}°C")
            Text("Weather: ${it.currentWeatherForecast}")
            // Add more weather details as needed
        }
        if (weather == null){
            Text("ssssssssssssssssssssssssss")
        }
    }
}