package com.example.weather.ui.serials

import androidx.lifecycle.ViewModel
import com.example.weather.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface SerialsDetailsModule {
    @ContributesAndroidInjector(
        modules = [
            SerialsDetailsViewModelModule::class
        ]
    )
    fun inject(): SerialsDetailsFragment
}

@Module
interface SerialsDetailsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SerialsDetailsViewModel::class)
    fun viewModel(viewModel: SerialsDetailsViewModel): ViewModel
}
