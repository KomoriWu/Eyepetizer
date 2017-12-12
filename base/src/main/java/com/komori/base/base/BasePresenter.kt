package com.komori.base.base

/**
 * Created by KomoriWu
 * on 2017-12-12.
 */

interface BasePresenter< in T : BaseView> {
    fun attachView(view:T)
    fun detachView()
}