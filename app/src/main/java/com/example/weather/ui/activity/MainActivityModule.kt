package com.example.weather.ui.activity

import com.example.weather.di.ActivityScope
import com.example.weather.ui.details.FragmentDetailsModule
import com.example.weather.ui.home.HomeFragmentModule
import com.example.weather.ui.serials.SerialsDetailsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            HomeFragmentModule::class,
            FragmentDetailsModule::class,
            SerialsDetailsModule::class
        ]
    )
    @ActivityScope
    fun activity(): MainActivity
}