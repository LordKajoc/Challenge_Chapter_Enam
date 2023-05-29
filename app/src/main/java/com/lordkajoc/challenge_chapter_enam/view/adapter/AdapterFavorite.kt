package com.lordkajoc.challenge_chapter_enam.view.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lordkajoc.challenge_chapter_enam.R
import com.lordkajoc.challenge_chapter_enam.data.local.FavoriteMovie
import com.lordkajoc.challenge_chapter_enam.databinding.ItemFilmfavBinding

@Suppress("unused")
class AdapterFavorite(private val listMovie: List<FavoriteMovie>) :
    RecyclerView.Adapter<AdapterFavorite.ViewHolder>() {


    class ViewHolder(var binding: ItemFilmfavBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindFilms(movie: FavoriteMovie) {
            binding.apply {
                binding.filmfav = movie
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w400${movie.posterPath}")
                    .into(binding.imgFilm)
                cardView.setOnClickListener {
                    val bundle = Bundle().apply {
                        putInt("ID", movie.id.toString().toInt())
                    }
                    it.findNavController()
                        .navigate(R.id.action_favoriteFragment_to_detailFragment, bundle)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemFilmfavBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindFilms(listMovie[position])
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

}