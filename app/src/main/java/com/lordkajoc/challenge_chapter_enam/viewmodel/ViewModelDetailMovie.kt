package com.lordkajoc.challenge_chapter_enam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lordkajoc.challenge_chapter_enam.data.local.FavoriteMovie
import com.lordkajoc.challenge_chapter_enam.data.local.FavoriteMovieDao
import com.lordkajoc.challenge_chapter_enam.data.network.ApiService
import com.lordkajoc.challenge_chapter_enam.model.DetailMovieItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelDetailMovie @Inject constructor(
    private val movieClient: ApiService, private val db: FavoriteMovieDao
) : ViewModel() {
    private val _movie: MutableLiveData<DetailMovieItem?> = MutableLiveData()
    val movie: LiveData<DetailMovieItem?> get() = _movie

    private val _FavMovie: MutableLiveData<FavoriteMovie> = MutableLiveData()
    val favMovie: LiveData<FavoriteMovie> get() = _FavMovie

    private val _DeleteFavMovie: MutableLiveData<FavoriteMovie> = MutableLiveData()
    val deleteFavMovie: LiveData<FavoriteMovie> get() = _DeleteFavMovie

    private val _IsFav: MutableLiveData<Boolean> = MutableLiveData()
    val isFav: LiveData<Boolean> get() = _IsFav

    fun getMovieById(id: Int) {
        movieClient.getMovieDetail(id)
            .enqueue(object : Callback<DetailMovieItem> {
                override fun onResponse(
                    call: Call<DetailMovieItem>,
                    response: Response<DetailMovieItem>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            _movie.postValue(responseBody)
                        }
                    }
                }

                override fun onFailure(call: Call<DetailMovieItem>, t: Throwable) {

                }

            })
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun isFavoriteMovie(id: Int) {
        GlobalScope.launch {
            _IsFav.postValue(db.isFavoriteMovie(id))
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun addFavMovie(favMovie: FavoriteMovie) {
        GlobalScope.launch {
            db.addFavorite(favMovie)
            _FavMovie.postValue(favMovie)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun deleteFavMovie(favMovie: FavoriteMovie) {
        GlobalScope.launch {
            db.deleteFavorite(favMovie)
            _DeleteFavMovie.postValue(favMovie)
        }
    }
}