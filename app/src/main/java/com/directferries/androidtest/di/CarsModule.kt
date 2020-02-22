
package com.directferries.androidtest.di

import androidx.lifecycle.ViewModel
import com.directferries.androidtest.presentation.MainActivity
import com.directferries.androidtest.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Dagger module for the cars.json list feature.
 */
@Module
abstract class CarsModule {
    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun mainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindViewModel(viewmodel: MainViewModel): ViewModel
}
