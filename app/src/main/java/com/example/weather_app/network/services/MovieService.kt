package com.example.weather_app.network.services

import com.example.weather_app.model.CityResponse
import com.example.weather_app.model.TrendingMovieResponse
import com.example.weather_app.model.MovieDesc
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit API Service
 */
interface MovieService {

    @GET("/3/trending/movie/week")
    suspend fun getPopularMovies() : Response<TrendingMovieResponse>

    @GET("/3/movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") id: Int) : Response<MovieDesc>

    @GET("/data/2.5/find")
    suspend fun getCitiesByLocation(@Query("lat") lat: Double, @Query("lon") lon: Double, @Query("appid") appid: String, ) : Response<CityResponse>
}