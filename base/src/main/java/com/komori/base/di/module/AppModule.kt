package com.komori.base.di.module


import com.komori.base.application.BaseApplication

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * Created by KomoriWu
 * on 2017-11-29.
 */

@Module
class AppModule(private val myApplication: BaseApplication) {

    @Provides
    @Singleton
    fun provideBaseApplication(): BaseApplication {
        return myApplication
    }

}
