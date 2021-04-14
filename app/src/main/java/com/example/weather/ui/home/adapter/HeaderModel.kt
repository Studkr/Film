package com.example.weather.ui.home.adapter

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.weather.R
import com.example.weather.system.BaseEpoxyHolder

@EpoxyModelClass(
    layout = R.layout.item_holder_header
)
abstract class HeaderModel: EpoxyModelWithHolder<HeaderModel.Holder>() {

    @EpoxyAttribute
    lateinit var headerText: String

    override fun bind(holder: Holder) {
        with(holder){
            headerName.text = headerText
        }
    }

    class Holder: BaseEpoxyHolder() {
        val headerName: TextView by bind(R.id.headerName)
    }
}