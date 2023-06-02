package com.lordkajoc.challenge_chapter_enam.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class ProductionCompaniesItemTest{
    @Test
    fun testProductionCompaniesItem() {
        // Arrange
        val logoPath = "/path/to/logo.jpg"
        val name = "Company Name"
        val id = 123
        val originCountry = "US"

        // Act
        val productionCompany = ProductionCompaniesItem(logoPath, name, id, originCountry)

        // Assert
        assertEquals(logoPath, productionCompany.logoPath)
        assertEquals(name, productionCompany.name)
        assertEquals(id, productionCompany.id)
        assertEquals(originCountry, productionCompany.originCountry)
    }
}