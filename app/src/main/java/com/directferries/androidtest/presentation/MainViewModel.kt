package com.directferries.androidtest.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.directferries.androidtest.domain.GetCarsUseCase

class MainViewModel(
    val getCarsUseCase: GetCarsUseCase
): ViewModel() {
    private val mutableLiveData by lazy {
        MutableLiveData<List<CarEntity>>().also {
            loadCars()
        }
    }

    fun getCars(): MutableLiveData<List<CarEntity>> {
        return mutableLiveData
    }

    private fun loadCars() {

    }
}