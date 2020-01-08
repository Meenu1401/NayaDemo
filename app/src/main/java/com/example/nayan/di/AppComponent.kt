package com.example.nayan.di

import com.example.gateway.scopes.AppScope
import com.example.nayan.NayanApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScope
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class, AppModule::class,ActivityModule::class]
)
interface AppComponent : AndroidInjector<NayanApplication> {


    @Component.Factory
    interface Factory : AndroidInjector.Factory<NayanApplication> {

    }
}