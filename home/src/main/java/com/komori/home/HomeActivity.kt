package com.komori.home

import com.komori.base.base.MvpBaseActivity
import com.komori.home.mvp.HomePresenter

class HomeActivity : MvpBaseActivity<HomePresenter>() {
    override fun showErrorMsg(msg: String) {
    }

    override fun setInject() {
    }

    override val layoutId: Int
        get() = R.layout.activity_home

    override fun init() {
    }

}
