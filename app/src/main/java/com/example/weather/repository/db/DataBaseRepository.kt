package com.example.weather.repository.db

import com.example.weather.db.entity.FavoriteFilmEntity
import com.example.weather.db.entity.FavoriteSerialsEntity
import com.example.weather.db.entity.WeatherEntity
import kotlinx.coroutines.flow.Flow

interface DataBaseRepository {
    suspend fun saveMovie(model: FavoriteFilmEntity)
    suspend fun getMovieList():List<FavoriteFilmEntity>
    suspend fun deleteMovie(model: FavoriteFilmEntity)

    suspend fun saveSerials(model:FavoriteSerialsEntity)
    suspend fun getSerialsList():List<FavoriteSerialsEntity>
    suspend fun deleteSerials(model: FavoriteSerialsEntity)
}