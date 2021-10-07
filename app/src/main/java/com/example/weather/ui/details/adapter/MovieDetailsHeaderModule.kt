package com.example.weather.ui.details.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.weather.R
import com.example.weather.repository.models.MovieDetailsModel
import com.example.weather.system.BaseEpoxyHolder
import com.example.weather.system.loadImage

@EpoxyModelClass(
    layout = R.layout.item_holder_movie_details_header
)
abstract class MovieDetailsHeaderModule : EpoxyModelWithHolder<MovieDetailsHeaderModule.Holder>() {

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var model: MovieDetailsModel

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var favClicked: View.OnClickListener? = null

    override fun bind(holder: Holder) {
        with(holder) {
            posterImage.loadImage(model.backdropPath)
            when (model.isFavorite) {
                true -> {
                    favoriteIcon.setImageResource(R.drawable.ic_round_favorite_24)
                }
                else -> {
                    favoriteIcon.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }
            }
            favoriteIcon.setOnClickListener(favClicked)
            movieName.text = model.originalTitle
            releaseDate.text = model.releaseDate
            overview.text = model.overview
        }
    }


    class Holder : BaseEpoxyHolder() {
        val posterImage: ImageView by bind(R.id.posterDetails)
        val movieName: TextView by bind(R.id.showDetailsName)
        val releaseDate: TextView by bind(R.id.releaseData)
        val overview: TextView by bind(R.id.overview)
        val favoriteIcon: ImageView by bind(R.id.favoriteDetails)
    }

}