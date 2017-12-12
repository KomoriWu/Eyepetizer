package com.komori.base.di.module

import android.app.Activity


import com.komori.base.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

/**
 * Created by KomoriWu
 * on 2017-12-12.
 */


@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityScope
    internal fun provideActivity(): Activity {
        return activity
    }

}
