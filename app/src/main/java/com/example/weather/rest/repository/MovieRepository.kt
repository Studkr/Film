package com.example.weather.rest.repository


import com.example.weather.rest.model.MovieDetailsResponceModel
import com.example.weather.rest.model.MovieModelResponce
import com.example.weather.rest.model.SerialsModelResponce
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
    suspend fun getWeekPopularMovieList(): MovieModelResponce
    suspend fun getPopularSerialsList():SerialsModelResponce
    suspend fun getMovieDetails(id: Long): MovieDetailsResponceModel
}