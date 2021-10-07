package com.example.weather.data.repository.db.impl

import com.example.weather.db.dao.MovieDao
import com.example.weather.db.dao.SerialsDao
import com.example.weather.db.entity.FavoriteFilmEntity
import com.example.weather.db.entity.FavoriteSerialsEntity
import com.example.weather.data.repository.db.DataBaseRepository
import javax.inject.Inject

class DataBaseRepositoryImpl @Inject constructor(
    private val serialsDao: SerialsDao,
    private val movieDao: MovieDao
) : DataBaseRepository {
    override suspend fun saveMovie(model: FavoriteFilmEntity) {
        movieDao.insert(model)
    }

    override suspend fun getMovieList(): List<FavoriteFilmEntity> = movieDao.getMovieList()

    override suspend fun deleteMovie(model: FavoriteFilmEntity) {
        movieDao.delete(model)
    }

    override suspend fun saveSerials(model: FavoriteSerialsEntity) {
        serialsDao.insert(model)
    }

    override suspend fun getSerialsList(): List<FavoriteSerialsEntity> = serialsDao.getSerialsList()

    override suspend fun deleteSerials(model: FavoriteSerialsEntity) {
        serialsDao.delete(model)
    }


}