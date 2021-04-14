package com.example.weather.ui.home.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.airbnb.epoxy.TypedEpoxyController
import com.example.weather.R
import com.example.weather.domain.use_case.models.FavoriteModel
import com.example.weather.system.BaseEpoxyHolder
import com.example.weather.system.loadImage

@EpoxyModelClass(
    layout = R.layout.item_holder_favorite
)
abstract class FavoriteAndroidModel: EpoxyModelWithHolder<FavoriteAndroidModel.Holder>() {
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var model:FavoriteModel

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: View.OnClickListener? = null
    override fun bind(holder: Holder) {
        with(holder){
            showName.text = model.name
            showPoster.loadImage(model.image)
            favoriteContainer.setOnClickListener(clickListener)
        }
    }

    override fun unbind(holder: Holder) {
        with(holder){
            favoriteContainer.setOnClickListener(null)
        }
    }


    class Holder: BaseEpoxyHolder(){
        val showName: TextView by bind( R.id.favoriteName)
        val showPoster: ImageView by bind(R.id.favoriteImage)
        val favoriteContainer: ViewGroup by bind(R.id.favoriteContainer)
    }
}