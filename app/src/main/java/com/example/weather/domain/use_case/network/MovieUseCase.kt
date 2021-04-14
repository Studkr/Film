package com.example.weather.domain.use_case.network

import com.example.weather.domain.use_case.models.MovieModel
import com.example.weather.rest.model.MovieDetailsResponceModel
import com.example.weather.rest.model.MovieModelResponce
import com.example.weather.rest.repository.MovieRepository
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
){

    suspend fun getMovieList(): List<MovieModel>{
        return  movieRepository.getWeekPopularMovieList().results.map {
            MovieModel.fromMovieModelResponse(it)
        }
    }

    suspend fun getMovieDetails(id: Long): MovieDetailsResponceModel = movieRepository.getMovieDetails(id)
}