package com.kev.gl.app.petsapp.ui.main.home

import androidx.lifecycle.ViewModel
import com.kev.gl.app.petsapp.data.model.Pet
import com.kev.gl.app.petsapp.data.repository.PetRepository
import com.kev.gl.app.petsapp.data.repository.PetRepositoryImpl

/**
 * @author Kevin Villalobos
 */
class HomeViewModel(private val petRepository: PetRepository = PetRepositoryImpl()) : ViewModel() {

    /**
     * Retrieves the Pets from the Repository
     */
    fun getPets(): List<Pet> {
        return petRepository.getPets()
    }

}