package com.kev.gl.app.petsapp.ui.main.home

import com.kev.gl.app.petsapp.data.io.PetsResponse
import com.kev.gl.app.petsapp.data.repository.PetRepository
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

/**
 * @author Kevin Villalobos
 */
class HomeViewModelTest {

    private val petRepository: PetRepository = Mockito.mock(PetRepository::class.java)
    private val viewModel: HomeViewModel = HomeViewModel(petRepository)

    @Test
    fun `Get Pets`() {
        // Given
        val response = PetsResponse()

        // Mock Repository Response
        `when`(petRepository.getPets()).thenReturn(response)

        // When
        val result = viewModel.getPets()

        // Then
        Assert.assertNotNull(result)
        Assert.assertEquals(response, result)
    }
}