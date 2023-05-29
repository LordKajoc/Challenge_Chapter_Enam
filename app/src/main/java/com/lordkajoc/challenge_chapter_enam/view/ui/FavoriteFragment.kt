package com.lordkajoc.challenge_chapter_enam.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lordkajoc.challenge_chapter_enam.databinding.FragmentFavoriteBinding
import com.lordkajoc.challenge_chapter_enam.view.adapter.AdapterFavorite
import com.lordkajoc.challenge_chapter_enam.viewmodel.ViewModelFavoriteMovie
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private lateinit var viewModel: ViewModelFavoriteMovie
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ViewModelFavoriteMovie::class.java]
        getAllFavMovies()
    }

    private fun getAllFavMovies() {
        viewModel.getAllFavoriteMovie()
        viewModel.listMovie.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.rvListfilmfav.layoutManager = LinearLayoutManager(requireContext())
                binding.rvListfilmfav.setHasFixedSize(false)
                binding.rvListfilmfav.adapter = AdapterFavorite(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
