package com.example.weather.ui.details

import androidx.lifecycle.ViewModel
import com.example.weather.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface FragmentDetailsModule {
    @ContributesAndroidInjector(modules = [
        FragmentDetailsViewModelModule::class
    ])
    fun inject():FragmentDetails
}

@Module
interface FragmentDetailsViewModelModule{
    @Binds
    @IntoMap
    @ViewModelKey(FragmentDetailsViewModel::class)
    fun viewModel (viewModel: FragmentDetailsViewModel):ViewModel
}