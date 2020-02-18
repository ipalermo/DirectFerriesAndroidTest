package com.directferries.androidtest.data

class CarRepository(
    private val raw: CarRawDataSource,
    private val memory: CarMemoryDataSource,
    private val room: CarRoomDataSource
) {
    fun getCars(): List<CarEntity> {
        return  memory.getCars() ?: room.getCars() ?: raw.getCars() ?: emptyList()
    }
}