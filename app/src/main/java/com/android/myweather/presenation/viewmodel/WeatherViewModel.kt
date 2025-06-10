package com.android.myweather.presenation.viewmodel

import android.Manifest
import android.content.Context
import android.location.LocationManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.myweather.domain.model.Location
import com.android.myweather.domain.model.Weather
import com.android.myweather.domain.usecase.GetCurrentLocationUseCase
import com.android.myweather.domain.usecase.GetCurrentWeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    val getCurrentLocationUseCase: GetCurrentLocationUseCase,
    val context: Context,
):ViewModel(){

    private val _locationData = MutableStateFlow<Location?>(null)
    val locationData: StateFlow<Location?> = _locationData.asStateFlow()

    private val _weatherData = MutableStateFlow<Weather?>(null)
    val weatherData: StateFlow<Weather?> = _weatherData.asStateFlow()

    private val _showLocationSettings = MutableStateFlow(false)
    val showLocationSettings: StateFlow<Boolean> = _showLocationSettings.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()


    fun getCurrentLocation() {
        if (!isLocationEnabled()) {
            _showLocationSettings.value = true
            return
        }
        viewModelScope.launch {
            try {
                val location = getCurrentLocationUseCase()
                _locationData.value = location
                val weather = getCurrentWeatherUseCase(location.latitude, location.longitude)
                _weatherData.value = weather
            } catch (e: Exception) {
                _errorMessage.value = "Failed to get location or weather"
            }
        }
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    fun checkPermission(): Boolean {
        return context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == android.content.pm.PackageManager.PERMISSION_GRANTED &&
                context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == android.content.pm.PackageManager.PERMISSION_GRANTED
    }

    fun resetErrorMessage() {
        _errorMessage.value = null
    }

    fun changeErrorMessage(msg: String){
        _errorMessage.value = msg
    }

    fun resetLocationSettingsPrompt() {
        _showLocationSettings.value = false
    }

}