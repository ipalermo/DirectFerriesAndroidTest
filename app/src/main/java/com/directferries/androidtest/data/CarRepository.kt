package com.directferries.androidtest.data

/**
 * Interface to the data layer.
 */
interface CarRepository {

    suspend fun getCars(): List<CarEntity>

}
