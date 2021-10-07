package com.example.weather.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.weather.R
import com.example.weather.databinding.HomeFragmentBinding
import com.example.weather.system.errorDialog
import com.example.weather.system.observe
import com.example.weather.ui.home.adapter.FilmsListModule
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment) {


    private val viewModel by viewModels<HomeViewModel>()


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

        lifecycleScope.launchWhenResumed {
            viewModel.combineModel.collect {
                filmAdapter.setData(it)
            }
        }
        lifecycleScope.launchWhenResumed {
            viewModel.showProgress.collect {
                binding.progressBar.isVisible = it
                binding.heroList.isVisible = !binding.progressBar.isVisible
            }
        }

        binding.filterButton.setOnClickListener {
            binding.drawerHome.openDrawer(GravityCompat.END)
        }
    }

    private fun openMovieDetails(id: Long){
       findNavController().navigate(R.id.fragmentDetails, bundleOf("id" to id))
    }


}