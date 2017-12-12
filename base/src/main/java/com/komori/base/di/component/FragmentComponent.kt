package com.komori.base.di.component


import com.komori.base.di.module.FragmentModule
import com.komori.base.di.scope.FragmentScope
import dagger.Component

/**
 * Created by KomoriWu
 * on 2017-12-12.
 */

@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
//    fun getActivity(): Activity
}
