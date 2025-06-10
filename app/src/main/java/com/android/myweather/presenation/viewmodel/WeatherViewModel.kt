package com.android.myweather.presenation.viewmodel

import android.Manifest
import android.content.Context
import android.location.LocationManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.myweather.domain.usecase.GetCurrentLocationUseCase
import com.android.myweather.domain.usecase.GetCurrentWeatherUseCase
import com.android.myweather.presenation.viewmodel.mapper.WeatherMapper
import com.android.myweather.presenation.viewmodel.state.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    val getCurrentLocationUseCase: GetCurrentLocationUseCase,
    val weatherMapper: WeatherMapper,
    val context: Context,
):ViewModel(){

    private val _cityName = MutableStateFlow<String?>(null)
    val cityName: StateFlow<String?> = _cityName.asStateFlow()

    private val _weatherUiData = MutableStateFlow<WeatherUiState>(WeatherUiState())
    val weatherUiData: StateFlow<WeatherUiState> = _weatherUiData.asStateFlow()

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
                val weather = getCurrentWeatherUseCase(location.latitude, location.longitude)
                _weatherUiData.value = weatherMapper.mapWeatherToWeatherUiState(weather)
                _cityName.value = location.city
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