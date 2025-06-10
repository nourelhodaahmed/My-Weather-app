package com.android.myweather.presenation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.android.myweather.domain.model.Location
import com.android.myweather.domain.repository.LocationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LocationViewModel(
    private val locationRepository: LocationRepository,
    private val context: Context
) : ViewModel() {

    private val _locationData = MutableStateFlow<Location?>(null)
    val locationData: StateFlow<Location?> = _locationData.asStateFlow()

    private val _showLocationSettings = MutableStateFlow(false)
    val showLocationSettings: StateFlow<Boolean> = _showLocationSettings.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

}