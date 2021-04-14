package com.example.weather.ui.home

import androidx.lifecycle.ViewModel
import com.example.weather.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface HomeFragmentModule {
    @ContributesAndroidInjector()
    fun inject(): HomeFragment

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun viewModel (viewModel: HomeViewModel):ViewModel
}