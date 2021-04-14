package com.example.weather.ui.details.adapter

import com.airbnb.epoxy.TypedEpoxyController
import com.example.weather.domain.use_case.models.MovieDetailsModel

class MovieDetailsController(
    val favoriteClicked:(model:MovieDetailsModel)-> Unit
): TypedEpoxyController<MovieDetailsModel>() {

    override fun buildModels(data: MovieDetailsModel?) {
        movieDetailsHeaderModule {
            id(data?.id)
            model(data)
            favClicked { model, _, _, _ ->
                favoriteClicked(model.model)
            }
        }
    }
}