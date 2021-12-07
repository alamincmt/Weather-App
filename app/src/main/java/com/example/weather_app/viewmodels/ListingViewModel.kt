package com.example.weather_app.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_app.data.CityRepository
import com.example.weather_app.data.MovieRepository
import com.example.weather_app.model.CityResponse
import com.example.weather_app.model.Result
import com.example.weather_app.model.TrendingMovieResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject
import javax.inject.Named

/**
 * ViewModel for CityListActivity
 */
@HiltViewModel
class ListingViewModel @Inject constructor(private val cityRepository: CityRepository,
                                           @Named("lat") lat: Double,
                                           @Named("lon") lon: Double,
                                           @Named("appid") appId: String) :
        ViewModel() {

    private val _cityList = MutableLiveData<Result<CityResponse>>()
    val cityList = _cityList

    init {
        fetchCities(lat, lon, appId)
    }

    private fun fetchCities(lat: Double, lon: Double, appId: String) {
        viewModelScope.launch {
            cityRepository.fetchCities(lat, lon, appId).collect {
                _cityList.value = it
            }
        }
    }
}