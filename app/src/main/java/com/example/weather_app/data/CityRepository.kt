package com.example.weather_app.data

import com.example.weather_app.data.remote.WeatherRemoteDataSource
import com.example.weather_app.model.CityResponse
import com.example.weather_app.data.local.MovieDao
import com.example.weather_app.data.remote.MovieRemoteDataSource
import com.example.weather_app.model.MovieDesc
import com.example.weather_app.model.Result
import com.example.weather_app.model.TrendingMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Repository which fetches data from Remote or Local data sources
 */
class CityRepository @Inject constructor(
        private val weatherRemoteDataSource: WeatherRemoteDataSource
) {

    suspend fun fetchCities(lat: Double, lon: Double, appId: String): Flow<Result<CityResponse>?> {
        return flow {
            emit(Result.loading())
            val result = weatherRemoteDataSource.fetchCities(lat, lon, appId)

            //Cache to database if response is successful
            if (result.status == Result.Status.SUCCESS) {
                /*result.data?.list?.let { it ->
                    cityDao.deleteAll(it)
                    cityDao.insertAll(it)
                }*/
            }
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}