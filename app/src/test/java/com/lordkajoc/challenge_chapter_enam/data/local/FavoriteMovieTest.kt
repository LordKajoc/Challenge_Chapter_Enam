package com.lordkajoc.challenge_chapter_enam.data.local

import org.junit.Assert.assertEquals
import org.junit.Test

class FavoriteMovieTest {

    @Test
    fun testFavoriteMovie() {
        // Arrange
        val id = 1
        val title = "Movie Title"
        val releaseDate = "2022-01-01"
        val posterPath = "/path/to/poster.jpg"

        // Act
        val favoriteMovie = FavoriteMovie(id, title, releaseDate, posterPath)

        // Assert
        assertEquals(id, favoriteMovie.id)
        assertEquals(title, favoriteMovie.title)
        assertEquals(releaseDate, favoriteMovie.releasedate)
        assertEquals(posterPath, favoriteMovie.posterPath)
    }
}
