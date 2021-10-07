package com.example.weather.ui.serials

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weather.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SerialsDetailsFragment : Fragment(R.layout.serials_details_fragment) {

    companion object {
        fun newInstance() = SerialsDetailsFragment()
    }



    private val viewModel: SerialsDetailsViewModel by viewModels ()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}