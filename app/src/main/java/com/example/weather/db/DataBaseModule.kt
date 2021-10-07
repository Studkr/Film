package com.example.weather.db

import android.content.Context
import com.example.weather.db.dao.MovieDao
import com.example.weather.db.dao.SerialsDao
import com.example.weather.db.dao.WeatherDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule @Inject constructor(

){
    lateinit var database: DataBase

    @Singleton
    @Provides
    fun provideDataBAse(@ApplicationContext context: Context):DataBase = DataBase.invoke(context)


    @Singleton
    @Provides
    fun provideSerialsDao(@ApplicationContext context: Context):SerialsDao = DataBase.invoke(context).serialsDao()

    @Singleton
    @Provides
    fun provideMovieDao(@ApplicationContext context: Context):MovieDao = DataBase.invoke(context).movieDao()
}