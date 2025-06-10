package com.android.myweather.domain.usecase

import com.android.myweather.domain.model.Location
import com.android.myweather.domain.repository.LocationRepository

class GetCurrentLocationUseCase(
    val locationRepository: LocationRepository
) {
    suspend operator fun invoke(): Location{
        return locationRepository.getLocation()
    }
}