package com.lordkajoc.challenge_chapter_enam.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteMovie::class], version = 1)
abstract class FavoriteMovieDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteMovieDao
//    companion object{
//        private var INSTANCE : FavoriteMovieDatabase? = null
//
//        fun getInstance(context : Context):FavoriteMovieDatabase? {
//            if (INSTANCE == null){
//                synchronized(FavoriteMovieDatabase::class){
//                    INSTANCE = Room.databaseBuilder(context.applicationContext,
//                        FavoriteMovieDatabase::class.java,"favoritmovie.db").build()
//                }
//            }
//            return INSTANCE
//        }
//
//        fun destroyInstance(){
//            INSTANCE = null
//        }
//    }

}
