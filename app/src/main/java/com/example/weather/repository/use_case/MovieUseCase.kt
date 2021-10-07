package com.example.weather.repository.use_case

import com.example.weather.repository.models.MovieModel
import com.example.weather.data.model.MovieDetailsResponceModel
import com.example.weather.data.repository.MovieRepository
import com.example.weather.system.BaseUseCase
import com.example.weather.system.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
):BaseUseCase() {

    operator fun invoke(): Flow<Result<List<MovieModel>>> = flow {
        movieRepository.getWeekPopularMovieList().catch { e ->
            emit(Result.error(e.message.toString(), null))
        }.collect {
            emit(Result.success(it.results.map {
                MovieModel.fromMovieModelResponse(it)
            }))

        }
    }.flowOn(dispatcher)
}