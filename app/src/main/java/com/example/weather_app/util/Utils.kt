package com.example.weather_app.util

import android.util.Patterns

class Utils {

    fun String.isValidEmail(): Boolean = this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

}