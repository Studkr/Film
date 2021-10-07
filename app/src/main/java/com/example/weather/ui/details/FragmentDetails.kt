package com.example.weather.ui.details


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weather.R
import com.example.weather.system.loadImage
import com.example.weather.system.observe
import com.example.weather.ui.details.adapter.MovieDetailsController
import com.idapgroup.argumentdelegate.argumentDelegate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_details_fragment.*

@AndroidEntryPoint
class FragmentDetails : Fragment(R.layout.fragment_details_fragment) {


    val id: Long by argumentDelegate()

    private val viewModel: FragmentDetailsViewModel by viewModels ()

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