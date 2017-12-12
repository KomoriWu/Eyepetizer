package com.komori.base.di.component


import com.komori.base.application.BaseApplication
import com.komori.base.di.module.AppModule

import javax.inject.Singleton

import dagger.Component

/**
 * Created by KomoriWu
 * on 2017-11-29.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    var context: BaseApplication
}
