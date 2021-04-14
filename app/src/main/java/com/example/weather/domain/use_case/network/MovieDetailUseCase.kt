package com.example.weather.domain.use_case.network

import com.example.weather.domain.use_case.DataBaseUseCase
import com.example.weather.domain.use_case.models.MovieDetailsModel
import com.example.weather.rest.repository.MovieRepository
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val dataBaseUseCase: DataBaseUseCase
) {

    suspend fun getMovieDetails(id: Long):MovieDetailsModel{
        return MovieDetailsModel.fromMovieDetailsResponse(movieRepository.getMovieDetails(id))
    }

}