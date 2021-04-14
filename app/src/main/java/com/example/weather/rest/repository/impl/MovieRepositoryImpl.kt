package com.example.weather.rest.repository.impl



import com.example.weather.BuildConfig
import com.example.weather.rest.model.MovieDetailsResponceModel

import com.example.weather.rest.model.MovieModelResponce
import com.example.weather.rest.model.SerialsModelResponce
import com.example.weather.rest.repository.MovieRepository
import com.example.weather.rest.repository.api.Api
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: Api
): MovieRepository {
    private val exceptionHandler = CoroutineExceptionHandler { context, exception ->
        println("Error ${exception.localizedMessage}")
    }
    private val defaultDispatcher = Dispatchers.IO
    private val emptyParentJob = SupervisorJob()
    private val combinedContext = defaultDispatcher + exceptionHandler + emptyParentJob

    override suspend fun getWeekPopularMovieList(): MovieModelResponce = withContext(combinedContext){
        api.getPopularMovies(BuildConfig.API_KEY)
    }

    override suspend fun getPopularSerialsList(): SerialsModelResponce = withContext(combinedContext) {
        api.getPopularSerials(BuildConfig.API_KEY)
    }

    override suspend fun getMovieDetails(id: Long): MovieDetailsResponceModel = withContext(combinedContext){
        api.getMovieDetails(id,BuildConfig.API_KEY)
    }


}