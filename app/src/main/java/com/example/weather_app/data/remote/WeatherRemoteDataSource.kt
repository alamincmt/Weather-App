package com.example.weather_app.data.remote

import com.example.weather_app.model.CityResponse
import com.example.weather_app.network.services.MovieService
import com.example.weather_app.util.ErrorUtils
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
import com.example.weather_app.model.Result

class WeatherRemoteDataSource @Inject constructor(private val retrofit: Retrofit){
    suspend fun fetchCities(lat: Double, lon: Double, appId: String): Result<CityResponse> {
        val weatherService = retrofit.create(MovieService::class.java)
        return getResponse(
            request = {weatherService.getCitiesByLocation(lat, lon, appId)},
            defaultErrorMessage = "Error fetching city list."
        )
    }

    private suspend fun <T> getResponse(request: suspend () -> Response<T>, defaultErrorMessage: String): Result<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result.isSuccessful) {
                return Result.success(result.body()!!)
            } else {
                val errorResponse = ErrorUtils.parseError(result, retrofit)
                Result.error(errorResponse?.status_message ?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            Result.error("Unknown Error", null)
        }
    }

}