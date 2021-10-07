package com.example.weather.ui.details

import androidx.lifecycle.viewModelScope
import com.example.weather.repository.DataBaseUseCase
import com.example.weather.repository.models.MovieDetailsModel
import com.example.weather.repository.use_case.MovieDetailUseCase
import com.example.weather.system.BaseViewModel
import com.example.weather.system.Status
import com.hadilq.liveevent.LiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class FragmentDetailsViewModel @Inject constructor(
    private val movieDetailsUseCase: MovieDetailUseCase,
    private val dataBaseUseCase: DataBaseUseCase
) : BaseViewModel() {

    val isFavorite = MutableStateFlow(false)
    private val _detailsResponse: MutableStateFlow<MovieDetailsModel?> = MutableStateFlow(null)
    val detailsSerials = _detailsResponse

    fun loadSerialsDetails(id: Long) {
      launch {
            movieDetailsUseCase.invoke(id).collect {
                when(it.status){
                    Status.SUCCESS -> {
                        combineDetails(it.data!!)
                    }
                    Status.ERROR -> {
                        errorEvent.value = it.message!!
                    }
                    Status.LOADING ->{

                    }
                }
            }
        }
    }
    private fun combineDetails(model: MovieDetailsModel){
        viewModelScope.launch {
            _detailsResponse.value = model.copy(isFavorite = dataBaseUseCase.isSavedMovie(model.id,model.title,model.posterPath,model.popularity))
        }
    }

    fun saveToFavorite(it: MovieDetailsModel) {
        viewModelScope.launch {
            dataBaseUseCase.saveFromMovieDetails(it)
        }
    }
}
