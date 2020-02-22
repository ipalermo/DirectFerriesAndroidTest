package com.directferries.androidtest.data

import com.directferries.androidtest.di.ApplicationModule.CarRoomDataSource
import com.directferries.androidtest.di.ApplicationModule.CarRawDataSource
import com.directferries.androidtest.di.ApplicationModule.CarMemoryDataSource
import javax.inject.Inject

class DefaultCarRepository @Inject constructor(
    @CarRawDataSource private val raw: CarDataSource,
    @CarMemoryDataSource private val memory: CarDataSource,
    @CarRoomDataSource private val room: CarDataSource
) : CarRepository {
    override suspend fun getCars(): List<CarEntity> {
        return  memory.getCars() ?: room.getCars() ?: raw.getCars() ?: emptyList()
    }
}