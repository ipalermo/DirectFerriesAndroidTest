package com.directferries.androidtest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.directferries.androidtest.data.CarEntity
import com.directferries.androidtest.domain.GetCarsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val getCarsUseCase: GetCarsUseCase
) : ViewModel() {

    private val _cars = MutableLiveData<List<CarEntity>>().apply { value = emptyList() }
    val cars: LiveData<List<CarEntity>> = _cars

    init {
        loadCars()
    }

    fun loadCars() {
        viewModelScope.launch {
            _cars.value = getCarsUseCase.getCars()
        }
    }
}