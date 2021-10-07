package com.example.weather.system

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.coroutines.CoroutineContext

open class BaseViewModel: ViewModel(),CoroutineScope {

    private val job = SupervisorJob()

    private val dispatcher = Dispatchers.Main

    override val coroutineContext: CoroutineContext
        get() = job + dispatcher + errorHandler

    val errorEvent: MutableStateFlow<String?> = MutableStateFlow(null)
    val showHideLoader = MutableStateFlow(true)

    private val errorHandler = CoroutineExceptionHandler { _, error ->
        error.printStackTrace()
         errorEvent.value = error.localizedMessage
    }

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }
}