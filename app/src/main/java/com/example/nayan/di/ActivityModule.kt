package com.example.nayan.di


import com.example.nayan.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule  {

    @ContributesAndroidInjector
    abstract fun mainActivity() : MainActivity

}