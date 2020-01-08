package com.example.nayan

import com.example.nayan.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class NayanApplication : DaggerApplication() {
    lateinit var injector: AndroidInjector<NayanApplication>

    override fun applicationInjector(): AndroidInjector<NayanApplication> {
        return injector
    }

    override fun onCreate() {
        this.injector = DaggerAppComponent.factory().create(this)
        super.onCreate()
    }

}