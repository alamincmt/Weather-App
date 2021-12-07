package com.example.weather_app.model

data class CityResponse(
    val cod: String,
    val count: Int,
    val list: List<CityObj>,
    val message: String
)