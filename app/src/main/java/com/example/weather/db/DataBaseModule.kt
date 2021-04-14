package com.example.weather.db

import android.content.Context
import com.example.weather.db.dao.MovieDao
import com.example.weather.db.dao.SerialsDao
import com.example.weather.db.dao.WeatherDao
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class DataBaseModule @Inject constructor(
    val context: Context
){
    val db = DataBase(context)

    @Singleton
    @Provides
    fun provideDataBAse():DataBase = DataBase.invoke(context)


    @Singleton
    @Provides
    fun provideSerialsDao():SerialsDao = DataBase.invoke(context).serialsDao()

    @Singleton
    @Provides
    fun provideMovieDao():MovieDao = DataBase.invoke(context).movieDao()
}