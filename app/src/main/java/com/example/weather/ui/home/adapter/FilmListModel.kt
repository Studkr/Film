package com.example.weather.ui.home.adapter

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.weather.R
import com.example.weather.domain.use_case.models.MovieModel

import com.example.weather.system.BaseEpoxyHolder
import com.example.weather.system.loadImage
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.progressindicator.CircularProgressIndicator

@EpoxyModelClass(
    layout = R.layout.item_holder_film_card
)
abstract class FilmListModel : EpoxyModelWithHolder<FilmListModel.Holder>() {

    @EpoxyAttribute
    lateinit var model: MovieModel

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var starListener: View.OnClickListener? = null

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var favClicked: View.OnClickListener? = null

    override fun bind(holder: Holder) {
        with(holder) {
            image.loadImage(model.posterPath)
            filmName.text = model.title
            ValueAnimator.ofInt(0, model.voteAverage.toInt()).apply {
                duration = 1000
                addUpdateListener {
                    filmRVoiteReiting.progress = it.animatedValue as Int
                    filmReiting.text = "${it.animatedValue}"
                }
            }.start()
            when(model.isFavorite){
                true ->{
                    favButton.setImageResource(R.drawable.ic_round_favorite_24)
                }
                false ->{
                    favButton.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }
            }

            favButton.setOnClickListener(favClicked)

            card.setOnClickListener(starListener)
        }
    }

    override fun unbind(holder: Holder) {
        with(holder) {
            card.setOnClickListener(null)
            favButton.setOnClickListener(null)
        }

    }

    class Holder : BaseEpoxyHolder() {
        val image: ShapeableImageView by bind(R.id.filmImage)
        val filmName: TextView by bind(R.id.filmName)
        val filmRVoiteReiting: ProgressBar by bind(R.id.voiteProgress)
        val filmReiting: TextView by bind(R.id.filmReiting)
        val card: ViewGroup by bind(R.id.layout)
        val favButton: ImageView by bind(R.id.favButton)
    }
}