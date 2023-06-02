package com.lordkajoc.challenge_chapter_enam.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class PopularMovieResponseTest {

    @Test
    fun testPopularMovieResponse() {
        // Arrange
        val page = 1
        val results = listOf(
            PopularMovieItem(
                adult = false,
                backdropPath = "/path/to/backdrop1.jpg",
                genreIds = listOf(1, 2),
                id = 1234,
                originalLanguage = "en",
                originalTitle = "Original Title 1",
                overview = "Overview 1",
                popularity = 7.8,
                posterPath = "/path/to/poster1.jpg",
                releaseDate = "2022-01-01",
                title = "Movie Title 1",
                video = false,
                voteAverage = 8.5,
                voteCount = 1000
            ),
            PopularMovieItem(
                adult = true,
                backdropPath = "/path/to/backdrop2.jpg",
                genreIds = listOf(3, 4),
                id = 5678,
                originalLanguage = "es",
                originalTitle = "Original Title 2",
                overview = "Overview 2",
                popularity = 6.2,
                posterPath = "/path/to/poster2.jpg",
                releaseDate = "2022-02-01",
                title = "Movie Title 2",
                video = true,
                voteAverage = 7.2,
                voteCount = 500
            )
            // Tambahkan objek PopularMovieItem lainnya sesuai kebutuhan
        )
        val totalPages = 5
        val totalResults = 100

        // Act
        val movieResponse = PopularMovieResponse(page, results, totalPages, totalResults)

        // Assert
        assertEquals(page, movieResponse.page)
        assertEquals(results, movieResponse.results)
        assertEquals(totalPages, movieResponse.totalPages)
        assertEquals(totalResults, movieResponse.totalResults)
    }
}