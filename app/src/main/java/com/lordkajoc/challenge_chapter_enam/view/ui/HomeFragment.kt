package com.lordkajoc.challenge_chapter_enam.view.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.lordkajoc.challenge_chapter_enam.R
import com.lordkajoc.challenge_chapter_enam.databinding.FragmentHomeBinding
import com.lordkajoc.challenge_chapter_enam.view.adapter.AdapterFilm
import com.lordkajoc.challenge_chapter_enam.viewmodel.ViewModelFilmPopular
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var viewModel: ViewModelFilmPopular

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ViewModelFilmPopular::class.java]
        observeMovie()
        (activity as AppCompatActivity).setSupportActionBar(binding.tbHome)

        firebaseAuth = FirebaseAuth.getInstance()
        if (firebaseAuth.currentUser == null) {
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }

        sharedPreferences = requireContext().getSharedPreferences("dataUser", Context.MODE_PRIVATE)

        val getUser = sharedPreferences.getString("user", "")
        binding.textView.text = "Welcome, $getUser"

        binding.ivIcprofile.setOnClickListener {
            val addUser = sharedPreferences.edit()
            addUser.putString("user", getUser)
            addUser.apply()
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
        binding.ivIcfavhome.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
        }
    }

    private fun observeMovie() {
        binding.rvListfilm.layoutManager = LinearLayoutManager(requireContext())
        binding.rvListfilm.setHasFixedSize(false)
        viewModel.setMoviesList()
        viewModel.movie.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.rvListfilm.adapter = AdapterFilm(it)
            }
        }
    }

}