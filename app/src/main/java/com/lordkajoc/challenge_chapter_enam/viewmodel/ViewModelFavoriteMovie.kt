package com.lordkajoc.challenge_chapter_enam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lordkajoc.challenge_chapter_enam.data.local.FavoriteMovie
import com.lordkajoc.challenge_chapter_enam.data.local.FavoriteMovieDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

//HiltViewModel dan Dependency Injection ke FavoriteMovieDao
@HiltViewModel
class ViewModelFavoriteMovie @Inject constructor(private val db: FavoriteMovieDao) : ViewModel() {

    //mutable LiveData List Item Favorite Movie
    private val _ListMovie: MutableLiveData<List<FavoriteMovie>> = MutableLiveData()
    val listMovie: LiveData<List<FavoriteMovie>> get() = _ListMovie

    @OptIn(DelicateCoroutinesApi::class)
    fun getAllFavoriteMovie() {
        GlobalScope.launch {
            _ListMovie.postValue(db.getAllFavorite())
        }
    }
}