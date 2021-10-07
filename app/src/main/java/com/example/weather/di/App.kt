package com.example.weather.di

import android.app.Application
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val handler = EpoxyAsyncUtil.getAsyncBackgroundHandler()
        EpoxyController.defaultDiffingHandler = handler
        EpoxyController.defaultModelBuildingHandler = handler

    }
}