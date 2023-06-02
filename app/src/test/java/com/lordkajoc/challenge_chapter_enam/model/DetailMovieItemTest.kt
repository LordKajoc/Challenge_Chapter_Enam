package com.lordkajoc.challenge_chapter_enam.model

import org.junit.Assert.assertEquals
import org.junit.Test

class DetailMovieItemTest {

    @Test
    fun testDetailMovieItem() {
        // Arrange
        val originalLanguage = "en"
        val imdbId = "tt1234567"
        val video = false
        val title = "Movie Title"
        val backdropPath = "/path/to/backdrop.jpg"
        val revenue = 1000000
        val genres = listOf(
            GenresItem("Action", 28),
            GenresItem("Drama", 18)
        )
        val popularity = 7.5
        val productionCountries = listOf(
            ProductionCountriesItem("US", "United States"),
            ProductionCountriesItem("UK", "United Kingdom")
        )
        val id = 1234
        val voteCount = 1000
        val budget = 500000
        val overview = "Movie overview"
        val originalTitle = "Original Title"
        val runtime = 120
        val posterPath = "/path/to/poster.jpg"
        val spokenLanguages = listOf(
            SpokenLanguagesItem("English", "en", "English"),
            SpokenLanguagesItem("Spanish", "es", "Spanish")
        )
        val productionCompanies = listOf(
            ProductionCompaniesItem("/path/to/logo1.jpg", "Company 1", 1, "US"),
            ProductionCompaniesItem("/path/to/logo2.jpg", "Company 2", 2, "UK")
        )
        val releaseDate = "2022-01-01"
        val voteAverage = 7.8
        val belongsToCollection = BelongsToCollection("/path/to/collection_backdrop.jpg", "Collection Name", 1, "/path/to/collection_poster.jpg")
        val tagline = "Movie tagline"
        val adult = false
        val homepage = "https://www.example.com"
        val status = "Released"

        // Act
        val detailMovieItem = DetailMovieItem(
            originalLanguage, imdbId, video, title, backdropPath, revenue, genres, popularity,
            productionCountries, id, voteCount, budget, overview, originalTitle, runtime,
            posterPath, spokenLanguages, productionCompanies, releaseDate, voteAverage,
            belongsToCollection, tagline, adult, homepage, status
        )

        // Assert
        assertEquals(originalLanguage, detailMovieItem.originalLanguage)
        assertEquals(imdbId, detailMovieItem.imdbId)
        assertEquals(video, detailMovieItem.video)
        assertEquals(title, detailMovieItem.title)
        assertEquals(backdropPath, detailMovieItem.backdropPath)
        assertEquals(revenue, detailMovieItem.revenue)
        assertEquals(genres, detailMovieItem.genres)
        assertEquals(popularity, detailMovieItem.popularity)
        assertEquals(productionCountries, detailMovieItem.productionCountries)
        assertEquals(id, detailMovieItem.id)
        assertEquals(voteCount, detailMovieItem.voteCount)
        assertEquals(budget, detailMovieItem.budget)
        assertEquals(overview, detailMovieItem.overview)
        assertEquals(originalTitle, detailMovieItem.originalTitle)
        assertEquals(runtime, detailMovieItem.runtime)
        assertEquals(posterPath, detailMovieItem.posterPath)
        assertEquals(spokenLanguages, detailMovieItem.spokenLanguages)
        assertEquals(productionCompanies, detailMovieItem.productionCompanies)
        assertEquals(releaseDate, detailMovieItem.releaseDate)
        assertEquals(voteAverage, detailMovieItem.voteAverage)
        assertEquals(belongsToCollection, detailMovieItem.belongsToCollection)
        assertEquals(tagline, detailMovieItem.tagline)
        assertEquals(adult, detailMovieItem.adult)
        assertEquals(homepage, detailMovieItem.homepage)
        assertEquals(status, detailMovieItem.status)
    }
}
