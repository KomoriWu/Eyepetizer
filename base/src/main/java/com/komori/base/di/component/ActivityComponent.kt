package com.komori.base.di.component

import android.app.Activity

import com.komori.base.di.module.ActivityModule
import com.komori.base.di.scope.ActivityScope

import dagger.Component

/**
 * Created by KomoriWu
 * on 2017-12-12.
 */

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun getActivity(): Activity
}
