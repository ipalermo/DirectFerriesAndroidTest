
package com.directferries.androidtest.di

import android.content.Context
import com.directferries.androidtest.data.*
import com.directferries.androidtest.data.CarMemoryDataSource

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlin.annotation.AnnotationRetention.RUNTIME


@Module(includes = [ApplicationModuleBinds::class])
object ApplicationModule {

    @Qualifier
    @Retention(RUNTIME)
    annotation class CarMemoryDataSource

    @Qualifier
    @Retention(RUNTIME)
    annotation class CarRawDataSource

    @Qualifier
    @Retention(RUNTIME)
    annotation class CarRoomDataSource

    @JvmStatic
    @Singleton
    @CarMemoryDataSource
    @Provides
    fun provideCarMemoryDataSource(): CarDataSource {
        return CarMemoryDataSource
    }

    @JvmStatic
    @Singleton
    @CarRawDataSource
    @Provides
    fun provideCarRawDataSource(context: Context): CarDataSource {
        return CarRawDataSource(context)
    }

    @JvmStatic
    @Singleton
    @CarRoomDataSource
    @Provides
    fun provideCarRoomDataSource(): CarDataSource {
        return CarRoomDataSource
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}

@Module
abstract class ApplicationModuleBinds {

    @Singleton
    @Binds
    abstract fun bindRepository(repo: DefaultCarRepository): CarRepository
}
