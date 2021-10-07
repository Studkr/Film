package com.example.weather.data.repository.impl



import com.example.weather.BuildConfig
import com.example.weather.data.model.MovieDetailsResponceModel

import com.example.weather.data.model.MovieModelResponce
import com.example.weather.data.model.SerialsModelResponce
import com.example.weather.data.repository.MovieRepository
import com.example.weather.data.api.ApiService
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): MovieRepository {

    override suspend fun getWeekPopularMovieList(): Flow<MovieModelResponce> = flow{
       emit(apiService.getPopularMovies(BuildConfig.API_KEY))
    }

    override suspend fun getPopularSerialsList(): Flow<SerialsModelResponce> = flow {
        emit(apiService.getPopularSerials(BuildConfig.API_KEY))
    }

    override suspend fun getMovieDetails(id: Long): Flow<MovieDetailsResponceModel> = flow{
        emit(apiService.getMovieDetails(id,BuildConfig.API_KEY))
    }


}