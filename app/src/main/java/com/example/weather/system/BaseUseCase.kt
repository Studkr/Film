package com.example.weather.system

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

open class BaseUseCase @Inject constructor(

): CoroutineScope {
    private val job = SupervisorJob()

    val dispatcher = Dispatchers.IO

    override val coroutineContext: CoroutineContext
        get() = job + dispatcher + errorHandler

    val errorEvent = MutableStateFlow("")

    private val errorHandler = CoroutineExceptionHandler { _, error ->
        error.printStackTrace()
        errorEvent.value = error.localizedMessage
    }
}