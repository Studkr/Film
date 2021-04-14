package com.example.weather.domain.use_case

import com.example.weather.db.entity.FavoriteFilmEntity
import com.example.weather.db.entity.FavoriteSerialsEntity
import com.example.weather.domain.use_case.models.MovieDetailsModel
import com.example.weather.domain.use_case.models.MovieModel
import com.example.weather.repository.db.DataBaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataBaseUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {


    suspend fun saveMovie(model: MovieModel) {
        dataBaseRepository.saveMovie(FavoriteFilmEntity(model.id,model.title,model.posterPath))
    }

    suspend fun saveSerials(model: FavoriteSerialsEntity) {
        dataBaseRepository.saveSerials(model)
    }

    suspend fun getSerialsList():List<FavoriteSerialsEntity> = withContext(Dispatchers.IO){
        dataBaseRepository.getSerialsList()
    }

    suspend fun getMovieList(): List<FavoriteFilmEntity> =  withContext(Dispatchers.IO){
        dataBaseRepository.getMovieList()
    }

    suspend fun deleteMovie(model: MovieModel){
        dataBaseRepository.deleteMovie(FavoriteFilmEntity(model.id,model.title,model.posterPath))
    }

    suspend fun deleteSerials(model:FavoriteSerialsEntity){
        dataBaseRepository.deleteSerials(model)
    }

    suspend fun saveFromMovieDetails(it: MovieDetailsModel) {
        dataBaseRepository.saveMovie(FavoriteFilmEntity(it.id,it.title,it.posterPath))
    }

    suspend fun isSavedMovie(id:Long,name:String,poster:String):Boolean = withContext(Dispatchers.IO){
        dataBaseRepository.getMovieList().contains(FavoriteFilmEntity(id,name,poster))
    }
}