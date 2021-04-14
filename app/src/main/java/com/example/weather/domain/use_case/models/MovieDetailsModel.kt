package com.example.weather.domain.use_case.models

import com.example.weather.rest.model.*


data class MovieDetailsModel(
    val adult: Boolean,
    val backdropPath: String,
    val budget: Long,
    val genres: List<GenreDetails>,
    val homepage: String,
    val id: Long,
    val imdbID: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompanyDetails>,
    val productionCountries: List<ProductionCountryDetails>,
    val releaseDate: String,
    val revenue: Long,
    val runtime: Long,
    val spokenLanguages: List<SpokenLanguageDetails>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Long,
    val isFavorite:Boolean = false
){
    companion object{
        fun fromMovieDetailsResponse(model: MovieDetailsResponceModel): MovieDetailsModel{
            return MovieDetailsModel(
                adult = model.adult,
                backdropPath = model.backdropPath,
                budget = model.budget,
                genres = model.genres.map { GenreDetails.fromGenre(it) },
                homepage = model.homepage,
                id = model.id,
                imdbID = model.imdbID,
                originalLanguage = model.originalLanguage,
                originalTitle = model.originalTitle,
                overview = model.overview,
                popularity = model.popularity,
                posterPath = model.posterPath,
                productionCompanies = model.productionCompanies.map { ProductionCompanyDetails.formProductionCompany(it) },
                productionCountries = model.productionCountries.map { ProductionCountryDetails.fromProdCountry(it) },
                releaseDate = model.releaseDate,
                revenue = model.revenue,
                runtime = model.runtime,
                spokenLanguages = model.spokenLanguages.map { SpokenLanguageDetails.fromSpokenLanguage(it) },
                status = model.status,
                tagline = model.tagline,
                title = model.title,
                video = model.video,
                voteAverage = model.voteAverage,
                voteCount = model.voteCount
            )
        }
    }
}


data class GenreDetails(
    val id: Long,
    val name: String
){
    companion object{
        fun fromGenre(model: Genre): GenreDetails{
            return GenreDetails(
                id = model.id,
                name = model.name
            )
        }
    }
}


data class ProductionCompanyDetails(
    val id: Long,
    val logoPath: String?,
    val name: String,
    val originCountry: String
){
    companion object{
        fun formProductionCompany(model:ProductionCompany):ProductionCompanyDetails{
            return ProductionCompanyDetails(
                id = model.id,
                logoPath = model.logoPath,
                name = model.name,
                originCountry = model.originCountry
            )
        }
    }
}



data class ProductionCountryDetails(
    val iso3166_1: String,
    val name: String
){
    companion object{
        fun fromProdCountry(model:ProductionCountry):ProductionCountryDetails{
            return ProductionCountryDetails(
                iso3166_1 = model.iso3166_1,
                name = model.name
            )
        }
    }
}

data class SpokenLanguageDetails(
    val englishName: String,
    val iso639_1: String,
    val name: String
){
    companion object{
        fun fromSpokenLanguage(model:SpokenLanguage):SpokenLanguageDetails{
            return SpokenLanguageDetails(
                englishName = model.englishName,
                iso639_1 = model.iso639_1,
                name = model.name
            )
        }
    }
}

