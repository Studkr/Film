package com.example.weather.ui.details


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.weather.R
import com.example.weather.di.viewmodel.ViewModelFactory
import com.example.weather.system.BaseFragment
import com.example.weather.system.loadImage
import com.example.weather.system.observe
import com.example.weather.ui.details.adapter.MovieDetailsController
import com.idapgroup.argumentdelegate.argumentDelegate
import kotlinx.android.synthetic.main.fragment_details_fragment.*
import javax.inject.Inject

class FragmentDetails : BaseFragment(R.layout.fragment_details_fragment) {


    val id: Long by argumentDelegate()

    @Inject
    lateinit var factory:ViewModelFactory

    private val viewModel: FragmentDetailsViewModel by viewModels {factory}

    private val controller = MovieDetailsController{
            viewModel.saveToFavorite(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadSerialsDetails(id)
        backButton.setOnClickListener {
            parentFragment?.childFragmentManager?.popBackStack()
        }
        
         observe(viewModel.detailsSerials){
            showName.text = it.title
            posterDetails.loadImage(it.backdropPath)
            showDetailsName.text = it.title
            releaseData.text = it.releaseDate
            overview.text = it.overview
             if(it.isFavorite){
                 favoriteDetails.setImageResource(R.drawable.ic_round_favorite_24)
             }else{
                 favoriteDetails.setImageResource(R.drawable.ic_baseline_favorite_border_24)
             }
        }
    }

}