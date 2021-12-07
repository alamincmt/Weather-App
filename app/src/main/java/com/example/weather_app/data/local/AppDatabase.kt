package com.example.weather_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weather_app.data.GenreConverters
import com.example.weather_app.model.Movie
import com.example.weather_app.model.User

@Database(entities = [Movie::class, User::class], version = 1)
@TypeConverters(GenreConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun userDao(): UserDao
}