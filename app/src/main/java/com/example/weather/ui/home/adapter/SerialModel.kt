package com.example.weather.ui.home.adapter

import android.animation.ValueAnimator
import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.weather.R
import com.example.weather.repository.models.SerialsModel
import com.example.weather.system.loadImage

@EpoxyModelClass(
    layout = R.layout.item_holder_film_card
)
abstract class SerialModel: EpoxyModelWithHolder<FilmListModel.Holder>() {
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var model: SerialsModel

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: View.OnClickListener? = null


    override fun bind(holder: FilmListModel.Holder) {
        with(holder){
            image.loadImage(model.posterPath)
            filmName.text = model.name
            ValueAnimator.ofInt(0,model.voteAverage.toInt()).apply {
                duration = 1000
                addUpdateListener {
                    filmRVoiteReiting.progress = it.animatedValue as Int
                    filmReiting.text = "${it.animatedValue}"
                }
            }.start()

            card.setOnClickListener(clickListener)
        }
    }

    override fun unbind(holder: FilmListModel.Holder) {
        with(holder){
            card.setOnClickListener(null)
        }
    }
}