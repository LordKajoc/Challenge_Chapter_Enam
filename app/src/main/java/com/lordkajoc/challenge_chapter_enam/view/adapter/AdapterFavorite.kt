package com.lordkajoc.challenge_chapter_enam.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lordkajoc.challenge_chapter_enam.data.local.FavoriteMovie
import com.lordkajoc.challenge_chapter_enam.databinding.ItemFilmfavBinding

class AdapterFavorite(private var listFilmfav: List<FavoriteMovie>) :
    RecyclerView.Adapter<AdapterFavorite.ViewHolder>() {

    class ViewHolder(var binding: ItemFilmfavBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindFilms(itemFilmsFav: FavoriteMovie) {
            binding.filmfav = itemFilmsFav
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemFilmfavBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindFilms(listFilmfav[position])
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500${listFilmfav[position].posterPath}")
            .into(holder.binding.imgFilm)
    }

    override fun getItemCount(): Int {
        return listFilmfav.size
    }

}