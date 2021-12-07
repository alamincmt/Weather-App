package com.example.weather_app.model

data class Error(val status_code: Int = 0,
                 val status_message: String? = null)