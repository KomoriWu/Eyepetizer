package com.komori.base.di.module

import android.app.Activity
import android.support.v4.app.Fragment

import com.komori.base.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

/**
 * Created by KomoriWu
 * on 2017-12-12.
 */
@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @FragmentScope
    internal fun provideActivity(): Activity? {
        return fragment.activity
    }

}
