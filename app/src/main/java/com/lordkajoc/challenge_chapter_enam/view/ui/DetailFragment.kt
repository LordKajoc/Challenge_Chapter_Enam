package com.lordkajoc.challenge_chapter_enam.view.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.lordkajoc.challenge_chapter_enam.R
import com.lordkajoc.challenge_chapter_enam.data.local.FavoriteMovie
import com.lordkajoc.challenge_chapter_enam.databinding.FragmentDetailBinding
import com.lordkajoc.challenge_chapter_enam.viewmodel.ViewModelDetailMovie
import dagger.hilt.android.AndroidEntryPoint
import kotlin.properties.Delegates

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
//    private var saveDao : FavoriteMovieDao?=null
//    private var saveDb : FavoriteMovieDatabase?=null
    private lateinit var viewModel: ViewModelDetailMovie
    private lateinit var selectedMovie: FavoriteMovie
    private var isFavorite by Delegates.notNull<Boolean>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val getfilm = arguments?.getSerializable("BUNDEL") as PopularMovieItem
//        Glide.with(view)
//            .load("https://image.tmdb.org/t/p/w500${getfilm.posterPath}")
//            .into(binding.ivFilmimagedetail)
//        binding.tvNamafilmdetail.text = getfilm.title
//        binding.tvReleasefilmdetail.text = "Release : ${getfilm.releaseDate}"
//        binding.tvPopularitydetail.text = "Popularity : ${getfilm.popularity}"
//        binding.tvSinopsisfilmdetail.text = """Overview:
//            ${getfilm.overview}
//        """.trimIndent()
        viewModel = ViewModelProvider(this)[ViewModelDetailMovie::class.java]
        val id = arguments?.getInt("ID")
        if (id != null) {
            viewModel.getMovieById(id)
            observeDetailMovie()
            setFavoriteListener()
            checkFavoriteMovie(id)

            //test crashlytics
            binding.btnCrashdetail.setOnClickListener {
                throw RuntimeException("Test Crash") // Force a crash
            }

//        saveDb = FavoriteMovieDatabase.getInstance(requireContext())
//        saveDao = saveDb?.favoriteDao()

        }
    }

    private fun observeDetailMovie() {
        viewModel.movie.observe(viewLifecycleOwner) {
            binding.apply {
                if (it != null) {
                    binding.tvNamafilmdetail.text = it.title.toString()
                    binding.tvReleasefilmdetail.text = it.releaseDate.toString()
                    Glide.with(requireContext())
                        .load("https://image.tmdb.org/t/p/w500/" + it.backdropPath)
                        .into(binding.ivFilmimagedetail)
                    binding.tvSinopsisfilmdetail.text = it.overview.toString()
                    selectedMovie = FavoriteMovie(
                        it.id!!,
                        it.title!!,
                        it.releaseDate!!,
                        it.posterPath!!
                    )
                }
            }
        }
    }

    private fun setFavoriteListener() {
        binding.icFav.apply {
            setOnClickListener {
                isFavorite = if (!isFavorite) {
                    addToFavorite(selectedMovie)
                    binding.icFav.setImageResource(R.drawable.ic_fav)
                    true
                } else {
                    deleteFromFavorite(selectedMovie)
                    binding.icFav.setImageResource(R.drawable.ic_not_fav)
                    false
                }
            }
        }
    }

    private fun addToFavorite(movie: FavoriteMovie) {
        viewModel.addFavMovie(movie)
        viewModel.favMovie.observe(viewLifecycleOwner) {
            if (it != null) {
                Toast.makeText(requireContext(), "Sukses tambah favorit", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Failed menambah favorit", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    private fun deleteFromFavorite(movie: FavoriteMovie) {
        viewModel.deleteFavMovie(movie)
        viewModel.deleteFavMovie.observe(viewLifecycleOwner) {
            if (it != null) {
                Toast.makeText(requireContext(), "Sukses menghapus favorit", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), "Failed menghapus favorit", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


    private fun checkFavoriteMovie(movieId: Int) {
        viewModel.isFavoriteMovie(movieId)
        viewModel.isFav.observe(viewLifecycleOwner) {
            if (it != null) {
                if (it) {
                    isFavorite = true
                    binding.icFav.setImageResource(R.drawable.ic_fav)
                } else {
                    isFavorite = false
                    binding.icFav.setImageResource(R.drawable.ic_not_fav)
                }
            } else {
                Log.d("CHECK_FAV", "checkFavoriteMovie: ${it}")
            }
        }
    }
//    override fun onResume() {
//        super.onResume()
//        binding.icFav.setOnClickListener {
//            val getFav = arguments?.getSerializable("BUNDEL") as PopularMovieItem
//            val title = getFav.title
//            val release = getFav.releaseDate
//            val posterpath = getFav.posterPath
//
//            GlobalScope.async {
//                val favfilm =  FavoriteMovie(getFav)
//                val result =saveDb?.favoriteDao()?.addFavorite(favfilm)
//                activity?.runOnUiThread {
//                    Toast.makeText(context, "Item added to Favorites", Toast.LENGTH_LONG)
//                        .show()
//                    Log.d("tes2", result.toString())
//                    Log.d("tes3", title)
//
//                }
//            }
//        }
//    }
}