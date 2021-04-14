package com.example.weather.domain.use_case.models

import com.example.weather.rest.model.SerialResponseModel
import com.fasterxml.jackson.annotation.JsonProperty

data class SerialsModel(
    val backdropPath: String,
    val firstAirDate: String,
    val genreIDS: List<Long>,
    val id: Long,
    val name: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Long,
    val isFavorite: Boolean = false
) {
    companion object{
        fun fromSerialResponse(model: SerialResponseModel): SerialsModel{
            return  SerialsModel(
                backdropPath = model.backdropPath,
                firstAirDate = model.firstAirDate,
                genreIDS = model.genreIDS,
                id = model.id,
                name = model.name,
                originCountry = model.originCountry,
                originalLanguage = model.originalLanguage,
                originalName = model.originalName,
                overview = model.overview,
                popularity = model.popularity,
                posterPath = model.posterPath,
                voteCount = model.voteCount,
                voteAverage = model.voteAverage
            )
        }
    }
}