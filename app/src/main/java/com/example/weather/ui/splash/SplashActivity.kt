package com.example.weather.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.weather.ui.activity.MainActivity
import com.example.weather.R
import com.example.weather.di.viewmodel.ViewModelFactory
import com.example.weather.system.BaseActivity
import com.example.weather.system.observe
import com.google.android.gms.location.*
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    private lateinit var  fusedLocationProviderClient: FusedLocationProviderClient

    @Inject
    lateinit var factory: ViewModelFactory

    val viewModel: SplashViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        observe(viewModel.openMainActivity){
            openMain()
        }
    }


    private fun openMain(){
        startActivity(Intent(this, MainActivity::class.java))
    }
}