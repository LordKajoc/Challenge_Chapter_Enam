package com.lordkajoc.challenge_chapter_enam.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class PopularMovieItemTest {

    @Test
    fun testPopularMovieItem() {
        // Arrange
        val adult = true
        val backdropPath = "/path/to/backdrop.jpg"
        val genreIds = listOf(1, 2, 3)
        val id = 123
        val originalLanguage = "en"
        val originalTitle = "Original Title"
        val overview = "Movie overview"
        val popularity = 7.8
        val posterPath = "/path/to/poster.jpg"
        val releaseDate = "2023-01-01"
        val title = "Movie Title"
        val video = false
        val voteAverage = 6.5
        val voteCount = 1000

        // Act
        val movieItem = PopularMovieItem(
            adult, backdropPath, genreIds, id, originalLanguage, originalTitle, overview,
            popularity, posterPath, releaseDate, title, video, voteAverage, voteCount
        )

        // Assert
        assertEquals(adult, movieItem.adult)
        assertEquals(backdropPath, movieItem.backdropPath)
        assertEquals(genreIds, movieItem.genreIds)
        assertEquals(id, movieItem.id)
        assertEquals(originalLanguage, movieItem.originalLanguage)
        assertEquals(originalTitle, movieItem.originalTitle)
        assertEquals(overview, movieItem.overview)
        assertEquals(popularity, movieItem.popularity, 0.001)
        assertEquals(posterPath, movieItem.posterPath)
        assertEquals(releaseDate, movieItem.releaseDate)
        assertEquals(title, movieItem.title)
        assertEquals(video, movieItem.video)
        assertEquals(voteAverage, movieItem.voteAverage, 0.001)
        assertEquals(voteCount, movieItem.voteCount)
    }
}