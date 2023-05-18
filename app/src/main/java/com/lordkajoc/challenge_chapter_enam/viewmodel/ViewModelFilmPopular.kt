package com.lordkajoc.challenge_chapter_enam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lordkajoc.challenge_chapter_enam.data.network.ApiClient
import com.lordkajoc.challenge_chapter_enam.data.network.ApiService
import com.lordkajoc.challenge_chapter_enam.model.PopularMovieItem
import com.lordkajoc.challenge_chapter_enam.model.PopularMovieResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelFilmPopular @Inject constructor(
    private val movieClient: ApiService,
) : ViewModel() {
    private val _movie: MutableLiveData<List<PopularMovieItem>> = MutableLiveData()
    val movie: LiveData<List<PopularMovieItem>> get() = _movie

    fun setMoviesList() {
        movieClient.getPopularmovie()
            .enqueue(object : Callback<PopularMovieResponse> {
                override fun onResponse(
                    call: Call<PopularMovieResponse>,
                    response: Response<PopularMovieResponse>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        if (data != null) {
                            _movie.postValue(data.results as List<PopularMovieItem>?)
                        }
                    }
                }

                override fun onFailure(call: Call<PopularMovieResponse>, t: Throwable) {

                }

            })
    }
}