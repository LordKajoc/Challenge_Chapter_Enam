package com.lordkajoc.challenge_chapter_enam.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class GenresItemTest {

    @Test
    fun testGenresItem() {
        // Arrange
        val name = "Action"
        val id = 28

        // Act
        val genresItem = GenresItem(name, id)

        // Assert
        assertEquals(name, genresItem.name)
        assertEquals(id, genresItem.id)
    }
}