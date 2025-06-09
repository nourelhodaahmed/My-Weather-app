package com.android.myweather.domain.exception

open class DomainExceptions(message: String) : Exception(message)

class NoWeatherFoundException : DomainExceptions("No weather found")
