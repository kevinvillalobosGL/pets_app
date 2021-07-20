package com.kev.gl.app.petsapp.data.repository

import com.kev.gl.app.petsapp.data.io.PetsResponse
import com.kev.gl.app.petsapp.data.service.LocalJsonHelper

/**
 * @author Kevin Villalobos
 */
interface PetRepository {

    /**
     * Get the List of Pets as a [PetsResponse]
     */
    fun getPets(): PetsResponse

}