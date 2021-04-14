package com.example.weather.ui.splash

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.weather.di.ActivityScope
import com.example.weather.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface SplashActivityModule {
    @ContributesAndroidInjector(
        modules = [
            SplashActivityActivityModule::class,
            SplashViewModelModule::class
        ]
    )

    @ActivityScope
    fun activity():SplashActivity
}

@Module
class SplashActivityActivityModule {
    @Provides
    @ActivityScope
    fun activity(a: SplashActivity): AppCompatActivity = a
}

@Module
interface SplashViewModelModule{
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun viewModel(viewModel: SplashViewModel):ViewModel
}