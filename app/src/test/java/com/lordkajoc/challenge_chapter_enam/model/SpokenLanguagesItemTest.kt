package com.lordkajoc.challenge_chapter_enam.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class SpokenLanguagesItemTest {
    @Test
    fun testSpokenLanguagesItem() {
        // Arrange
        val name = "Language Name"
        val iso6391 = "en"
        val englishName = "English"

        // Act
        val spokenLanguage = SpokenLanguagesItem(name, iso6391, englishName)

        // Assert
        assertEquals(name, spokenLanguage.name)
        assertEquals(iso6391, spokenLanguage.iso6391)
        assertEquals(englishName, spokenLanguage.englishName)
    }
}