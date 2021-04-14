package com.example.weather.system

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.weather.Constants

fun ImageView.loadImage(image: String){
    Glide.with(this)
        .load(Constants.IMAGE_URL+image)
        .into(this)
}