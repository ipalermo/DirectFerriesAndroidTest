package com.directferries.androidtest

import com.directferries.androidtest.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * An [Application] that uses Dagger for Dependency Injection.
 */
open class AndroidTestApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerApplicationComponent.factory().create(applicationContext)
    }
}
