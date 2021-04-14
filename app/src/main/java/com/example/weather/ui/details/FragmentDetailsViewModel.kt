package com.example.weather.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.weather.db.entity.FavoriteFilmEntity
import com.example.weather.domain.use_case.DataBaseUseCase
import com.example.weather.domain.use_case.models.MovieDetailsModel
import com.example.weather.domain.use_case.network.MovieDetailUseCase
import com.example.weather.rest.model.MovieDetailsResponceModel
import com.example.weather.rest.repository.MovieRepository
import com.example.weather.system.BaseViewModel
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentDetailsViewModel @Inject constructor(
    private val movieDetailsUseCase: MovieDetailUseCase,
    private val dataBaseUseCase: DataBaseUseCase
) : BaseViewModel() {

    val errorMessage = LiveEvent<String>()

    private val exceptionHandler = CoroutineExceptionHandler { context, exception ->
        println("Error ${exception.localizedMessage}")
        errorMessage.value = exception.localizedMessage
    }

    val isFavorite = MutableStateFlow(false)
    private val _detailsResponse: MutableStateFlow<MovieDetailsModel?> = MutableStateFlow(null)

    val detailsSerials = _detailsResponse

    fun loadSerialsDetails(id: Long) {
        viewModelScope.launch(exceptionHandler) {
           combineDetails(movieDetailsUseCase.getMovieDetails(id))

        }
    }
    private fun combineDetails(model: MovieDetailsModel){
        viewModelScope.launch {
            _detailsResponse.value = model.copy(isFavorite = dataBaseUseCase.isSavedMovie(model.id,model.title,model.posterPath))
        }
    }

    fun saveToFavorite(it: MovieDetailsModel) {
        viewModelScope.launch {
            dataBaseUseCase.saveFromMovieDetails(it)
        }
    }
}
