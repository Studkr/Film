package com.example.weather.repository.use_case

import com.example.weather.repository.DataBaseUseCase
import com.example.weather.repository.models.MovieDetailsModel
import com.example.weather.data.repository.MovieRepository
import com.example.weather.system.BaseUseCase
import com.example.weather.system.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(
    private val movieRepository: MovieRepository
):BaseUseCase() {

    operator fun invoke(id: Long): Flow<Result<MovieDetailsModel>> = flow{
                movieRepository.getMovieDetails(id).catch { e ->
                    emit(Result.error(e.message.toString(),null))
                }.collect {
                    emit(Result.success(MovieDetailsModel.fromMovieDetailsResponse(it)))
                }
    }.flowOn(dispatcher)


}