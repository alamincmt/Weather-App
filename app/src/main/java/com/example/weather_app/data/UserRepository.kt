package com.example.weather_app.data

import com.example.weather_app.data.local.UserDao
import com.example.weather_app.model.MovieDesc
import com.example.weather_app.model.Result
import com.example.weather_app.model.TrendingMovieResponse
import com.example.weather_app.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
){
    suspend fun getUserByNameAndPassword(name: String, password: String) : User{
        val result = userDao.getUserByUserNameAndPassword(name, password)
        return result!!
    }

    suspend fun createUser(user: User){
        userDao.insert(user)
    }
}