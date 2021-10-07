package com.example.weather.repository.use_case

import com.example.weather.repository.models.SerialsModel
import com.example.weather.data.repository.MovieRepository
import com.example.weather.system.BaseUseCase
import com.example.weather.system.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class SerialsUseCase @Inject constructor(
    private val serials: MovieRepository
):BaseUseCase() {

  operator fun invoke(): Flow<Result<List<SerialsModel>>> = flow  {
        serials.getPopularSerialsList().catch { e->
            emit(Result.error(e.message.toString(),null))
        }.collect { result ->
            emit(Result.success(result.results.map { SerialsModel.fromSerialResponse(it)}))
        }
    }.flowOn(dispatcher)

}