package com.android.myweather.di

import com.android.myweather.data.remote.mapper.WeatherMapper
import com.android.myweather.data.remote.repository.LocationRepositoryImpl
import com.android.myweather.data.remote.repository.WeatherRepositoryImpl
import com.android.myweather.domain.repository.LocationRepository
import com.android.myweather.domain.repository.WeatherRepository
import com.android.myweather.domain.usecase.GetCurrentLocationUseCase
import com.android.myweather.domain.usecase.GetCurrentWeatherUseCase
import com.android.myweather.presenation.viewmodel.WeatherViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<FusedLocationProviderClient> {
        LocationServices.getFusedLocationProviderClient(androidContext())
    }
    //single<HttpClient> { HttpClient(CIO) }
    single<LocationRepository> {
        LocationRepositoryImpl(
            fusedLocationProviderClient = get(),
            context = androidContext()
        )
    }
    single<WeatherRepository> {
        WeatherRepositoryImpl(
            weatherMapper = get()
        )
    }
    single { WeatherMapper() }
    single { GetCurrentLocationUseCase(get()) }
    single { GetCurrentWeatherUseCase(get()) }
    viewModel {
        WeatherViewModel(
            getCurrentWeatherUseCase = get(),
            getCurrentLocationUseCase = get(),
            context = androidContext()
        )
    }
}

