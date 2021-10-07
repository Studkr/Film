package com.example.weather.data.repository


import com.example.weather.data.model.MovieDetailsResponceModel
import com.example.weather.data.model.MovieModelResponce
import com.example.weather.data.model.SerialsModelResponce
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
    suspend fun getWeekPopularMovieList(): Flow<MovieModelResponce>
    suspend fun getPopularSerialsList():Flow<SerialsModelResponce>
    suspend fun getMovieDetails(id: Long): Flow<MovieDetailsResponceModel>
}