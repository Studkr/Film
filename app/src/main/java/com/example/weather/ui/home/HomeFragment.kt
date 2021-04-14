package com.example.weather.ui.home


import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.weather.R
import com.example.weather.databinding.HomeFragmentBinding
import com.example.weather.di.viewmodel.ViewModelFactory
import com.example.weather.system.BaseFragment
import com.example.weather.system.errorDialog
import com.example.weather.system.observe
import com.example.weather.ui.home.adapter.FilmsListModule
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.home_fragment.*

import javax.inject.Inject

class HomeFragment : BaseFragment(R.layout.home_fragment) {

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel by viewModels<HomeViewModel> { factory }


    private lateinit var binding: HomeFragmentBinding

    private val filmAdapter = FilmsListModule({
        viewModel.movieClicked(it)
        openMovieDetails(it.id)
    },{
       // viewModel.serialsClicked(it)
        },
        saveMovie = {
            viewModel.saveMovieToFavorite(it)
    }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.errorMessage) {
            errorDialog(requireContext(), it) {}
        }

        binding.heroList.adapter = filmAdapter.adapter

        observe(viewModel.combineModel) {
            binding.progressBar.isVisible = it.serialList.isEmpty()
            binding.heroList.isVisible = !binding.progressBar.isVisible
            filmAdapter.setData(it)
        }

        binding.filterButton.setOnClickListener {
            binding.drawerHome.openDrawer(GravityCompat.END)
        }
    }

    private fun openMovieDetails(id: Long){
       findNavController().navigate(R.id.fragmentDetails, bundleOf("id" to id))
    }


}