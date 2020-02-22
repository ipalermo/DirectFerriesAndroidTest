package com.directferries.androidtest.domain

import com.directferries.androidtest.data.DefaultCarRepository
import javax.inject.Inject

/* This example use case is very simple, but all business logic to be applied after retrieving
 the cars.json from the repository should be placed in this class
 */
class GetCarsUseCase @Inject constructor(
    private val repository: DefaultCarRepository
) {
    suspend fun getCars() = repository.getCars()
}