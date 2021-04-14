package com.example.weather.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.weather.db.entity.FavoriteFilmEntity
import com.example.weather.db.entity.FavoriteSerialsEntity
import com.example.weather.domain.use_case.DataBaseUseCase
import com.example.weather.domain.use_case.models.MovieModel
import com.example.weather.domain.use_case.models.SerialsModel
import com.example.weather.domain.use_case.network.MovieUseCase
import com.example.weather.domain.use_case.network.SerialsUseCase
import com.example.weather.ui.home.adapter.FavoriteAndroidModel
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val dataBaseUseCase: DataBaseUseCase,
    private val movieUseCase: MovieUseCase,
    private val serialsUseCase: SerialsUseCase
) : ViewModel() {

    val errorMessage = LiveEvent<String>()

    private val exceptionHandler = CoroutineExceptionHandler { context, exception ->
        println("Error ${exception.localizedMessage}")
        errorMessage.value = exception.localizedMessage
    }

    private val movieList = MutableStateFlow<List<MovieModel>>(emptyList())
    private val serialsList = MutableStateFlow<List<SerialsModel>>(emptyList())
    private val savedMovie = MutableStateFlow<List<FavoriteFilmEntity>>(emptyList())
    private val savedSerials = MutableStateFlow<List<FavoriteSerialsEntity>>(emptyList())

    private val combineList =
        movieList.combine(serialsList.filterNotNull()) { movieList, serialList ->
            CombineModel(
                movieList = movieList,
                serialList = serialList,
                favorite = emptyList()
            )
        }

    val combineModel = combineList.asLiveData()

    init {
        viewModelScope.launch (exceptionHandler){
            savedMovie.value = dataBaseUseCase.getMovieList()
            savedSerials.value = dataBaseUseCase.getSerialsList()
        }
        loadMovieList()
    }


    private fun loadMovieList() {
        viewModelScope.launch(exceptionHandler) {
            movieList.value = movieUseCase.getMovieList().map {
                it.copy(isFavorite = savedMovie.value.contains(FavoriteFilmEntity(it.id,it.title,it.posterPath)))
            }
            serialsList.value = serialsUseCase.getSerialsList().map {
                it.copy(isFavorite = savedSerials.value.contains(FavoriteSerialsEntity(it.id,it.name)))
            }
        }
    }

    fun movieClicked(it: MovieModel) {

    }

    fun serialsClicked(it: SerialsModel) {

    }

    fun saveMovieToFavorite(movie: MovieModel) {
        viewModelScope.launch(exceptionHandler) {
            if(!movie.isFavorite){
                dataBaseUseCase.saveMovie(movie)
                movieList.value = movieList.value.map {
                    if(it == movie){
                        it.copy(isFavorite = true)
                    }else{
                        it.copy(isFavorite = it.isFavorite)
                    }
                }
            }else{
                dataBaseUseCase.deleteMovie(movie)
                movieList.value = movieList.value.map {
                    if(it == movie){
                        it.copy(isFavorite = false)
                    }else{
                        it.copy(isFavorite = it.isFavorite)
                    }
                }
            }
        }
    }


}

data class CombineModel(
    val movieList: List<MovieModel>,
    val serialList: List<SerialsModel>,
    val favorite:List<FavoriteAndroidModel>
)