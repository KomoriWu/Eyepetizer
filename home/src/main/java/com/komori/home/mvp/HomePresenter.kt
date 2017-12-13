package com.komori.home.mvp


import com.komori.base.base.RxPresenter
import javax.inject.Inject

/**
 * Created by KomoriWu
 * on 2017-12-13.
 */


class HomePresenter @Inject
constructor() : RxPresenter<HomeContract.View>(), HomeContract.Presenter {

    override fun toStr() {
        view!!.showStr("sssssssssssssss")
    }
}
