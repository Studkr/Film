package com.example.weather.ui.serials

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.weather.R
import com.example.weather.di.viewmodel.ViewModelFactory
import com.example.weather.system.BaseFragment
import javax.inject.Inject

class SerialsDetailsFragment : BaseFragment(R.layout.serials_details_fragment) {

    companion object {
        fun newInstance() = SerialsDetailsFragment()
    }

    @Inject
    lateinit var factory:ViewModelFactory

    private val viewModel: SerialsDetailsViewModel by viewModels { factory }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}