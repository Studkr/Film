package com.example.weather.ui.home.adapter

import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.example.weather.domain.use_case.models.MovieModel
import com.example.weather.ui.home.CombineModel

class FilmsListModule(
    val filmClicked:(model: MovieModel)->Unit,
    val serialClicked:(model:SerialModel)-> Unit,
    val saveMovie:(model: MovieModel) -> Unit
) : TypedEpoxyController<CombineModel>() {

    override fun buildModels(data: CombineModel) {

        header {
            id("movie")
            headerText("Popular Movies")
        }

        carousel {
            id("film")
            hasFixedSize(true)
            models(data.movieList.mapIndexed { index, movieModel ->
                FilmListModel_()
                    .id(index)
                    .model(movieModel)
                    .starListener { model, parentView, clickedView, position ->
                        filmClicked(model.model)
                    }.favClicked { model, parentView, clickedView, position ->
                        saveMovie(model.model)
                    }
            })

        }

        header {
            id("serial")
            headerText("Popular TV Show")
        }

        carousel {
            id("serials")
            hasFixedSize(true)
            models(data.serialList.mapIndexed { index, serialModel ->
                SerialModel_()
                    .id(index)
                    .model(serialModel)
                    .clickListener { model, parentView, clickedView, position ->

                    }
            })
        }

    }

}