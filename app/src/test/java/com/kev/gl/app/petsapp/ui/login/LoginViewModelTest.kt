package com.kev.gl.app.petsapp.ui.login

import org.junit.Assert
import org.junit.Test

/**
 * @author Kevin Villalobos
 */
class LoginViewModelTest {

    private val viewModel = LoginViewModel()

    @Test
    fun `Successful Login`() {
        // Given
        val username = "test@gorillalogic.com"
        val password = "bar"

        // When
        val result = viewModel.doLogin(username, password)

        // Then
        Assert.assertTrue(result)
    }

    @Test
    fun `Unsuccessful Login`() {
        // Given
        val username = "test@gl.com"
        val password = "bar"

        // When
        val result = viewModel.doLogin(username, password)

        // Then
        Assert.assertFalse(result)
    }
}