package com.directferries.androidtest.domain

import com.directferries.androidtest.data.CarRepository
import com.directferries.androidtest.presentation.CarEntity

class GetCarsUseCase (
    private val repository:CarRepository
) {
    fun getCars() : List<CarEntity> {
        return repository.getCars().map {
            CarEntity(it.make, it.model, it.id)
        }
    }
}