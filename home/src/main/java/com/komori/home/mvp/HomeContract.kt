package com.komori.home.mvp


import com.komori.base.base.BasePresenter
import com.komori.base.base.BaseView

/**
 * Created by KomoriWu
 * on 2017-12-13.
 */

interface HomeContract {
    interface View : BaseView {
        fun showStr(str:String)
    }

    interface Presenter : BasePresenter<View> {
        fun toStr()
    }

}
