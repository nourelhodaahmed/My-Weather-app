package com.android.myweather.domain.repository

import com.android.myweather.domain.model.Location

interface LocationRepository {
    suspend fun getLocation(): Location
}