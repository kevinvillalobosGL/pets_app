package com.kev.gl.app.petsapp.data.repository

import com.kev.gl.app.petsapp.data.io.PetsResponse
import com.kev.gl.app.petsapp.data.service.LocalJsonHelper

/**
 * @author Kevin Villalobos
 */
class PetRepositoryImpl : PetRepository {

    /**
     * Get the List of Pets from the Local Jason File
     */
    override fun getPets(): PetsResponse {
        return LocalJsonHelper.getFromFile("pets.json")
    }

}