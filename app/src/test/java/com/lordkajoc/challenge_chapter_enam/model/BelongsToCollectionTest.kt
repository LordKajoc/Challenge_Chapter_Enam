package com.lordkajoc.challenge_chapter_enam.model

import org.junit.Assert.assertEquals
import org.junit.Test

class BelongsToCollectionTest {

    @Test
    fun testBelongsToCollection() {
        // Arrange
        val backdropPath = "/path/to/backdrop.jpg"
        val name = "Collection Name"
        val id = 1234
        val posterPath = "/path/to/poster.jpg"

        // Act
        val belongsToCollection = BelongsToCollection(backdropPath, name, id, posterPath)

        // Assert
        assertEquals(backdropPath, belongsToCollection.backdropPath)
        assertEquals(name, belongsToCollection.name)
        assertEquals(id, belongsToCollection.id)
        assertEquals(posterPath, belongsToCollection.posterPath)
    }
}
