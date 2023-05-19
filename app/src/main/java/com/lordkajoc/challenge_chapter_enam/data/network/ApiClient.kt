package com.lordkajoc.challenge_chapter_enam.data.network

import android.content.Context
import androidx.room.Room
import com.lordkajoc.challenge_chapter_enam.data.local.FavoriteMovieDao
import com.lordkajoc.challenge_chapter_enam.data.local.FavoriteMovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiClient {

    @Singleton
    @Provides
    fun getMovieService(): ApiService {
        val loggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideFavoriteDAO(db: FavoriteMovieDatabase): FavoriteMovieDao = db.favoriteDao()

    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context: Context): FavoriteMovieDatabase {
        return Room.databaseBuilder(context, FavoriteMovieDatabase::class.java, "favorite.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}