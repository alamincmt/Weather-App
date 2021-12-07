package com.example.weather_app.data.local

import androidx.room.*
import androidx.room.Dao
import com.example.weather_app.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<User>?

    @Query("SELECT * FROM user WHERE user_name = :user_name AND password = :password")
    fun getUserByUserNameAndPassword(user_name: String, password: String): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Delete
    fun deleteAll(users: List<User>)
}