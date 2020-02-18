package com.directferries.androidtest.data

interface CarDataSource {
    fun getCars(): List<CarEntity>?
}