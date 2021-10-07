package com.example.weather.repository.models

import com.example.weather.data.model.MovieResponseModel

data class MovieModel(
    val video: Boolean,
    val voteAverage: Double,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val adult: Boolean,
    val backdropPath: String,
    val id: Long,
    val genreIDS: List<Long>,
    val voteCount: Long,
    val originalLanguage: String,
    val originalTitle: String,
    val posterPath: String,
    val popularity: Double,
    val mediaType: String,
    val isFavorite: Boolean = false,
) {
    companion object {
        fun fromMovieModelResponse(model: MovieResponseModel): MovieModel {
            return MovieModel(
                video = model.video,
                voteAverage = model.voteAverage,
                title = model.title,
                overview = model.overview,
                releaseDate = model.releaseDate,
                adult = model.adult,
                backdropPath = model.backdropPath,
                id = model.id,
                genreIDS = model.genreIDS,
                voteCount = model.voteCount,
                originalLanguage = model.originalLanguage,
                originalTitle = model.originalTitle,
                posterPath = model.posterPath,
                popularity = model.popularity,
                mediaType = model.mediaType
            )
        }
    }
}