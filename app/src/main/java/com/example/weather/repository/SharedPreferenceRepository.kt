package com.example.weather.repository

interface SharedPreferenceRepository {
    fun firstLaunch()
    fun saveFirstLaunch()
}