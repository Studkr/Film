package com.example.weather.ui.splash

import androidx.lifecycle.viewModelScope
import com.example.weather.repository.db.DataBaseRepository
import com.example.weather.rest.repository.MovieRepository
import com.example.weather.system.BaseViewModel
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.*
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val dataBaseRepository: DataBaseRepository,
    private val movieRepository: MovieRepository
): BaseViewModel() {

    val errorMessage = LiveEvent<String>()

    private val exceptionHandler = CoroutineExceptionHandler { context, exception ->
        errorMessage.value = exception.localizedMessage
    }

    val openMainActivity = LiveEvent<Unit>()
  init {
      viewModelScope.launch(exceptionHandler){
        delay(2000)
          openMainActivity.value = Unit
      }
  }



}

