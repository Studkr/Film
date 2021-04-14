package com.example.weather.domain.use_case.network

import com.example.weather.domain.use_case.models.SerialsModel
import com.example.weather.rest.model.SerialsModelResponce
import com.example.weather.rest.repository.MovieRepository
import javax.inject.Inject

class SerialsUseCase @Inject constructor(
    private val serials: MovieRepository
) {

    suspend fun getSerialsList(): List<SerialsModel> {
        return serials.getPopularSerialsList().results.map {
            SerialsModel.fromSerialResponse(it)
        }
    }

}