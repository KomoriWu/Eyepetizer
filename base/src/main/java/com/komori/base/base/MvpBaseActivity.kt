package com.komori.base.base

import com.komori.base.application.BaseApplication
import com.komori.base.di.component.ActivityComponent
import com.komori.base.di.component.DaggerActivityComponent
import com.komori.base.di.module.ActivityModule
import javax.inject.Inject

/**
 * Created by KomoriWu
 * on 2017-12-12.
 */

abstract class MvpBaseActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    @JvmField
    @Inject
    var presenter: T? = null

    abstract fun setInject()

    fun getActivityComponent(): ActivityComponent {
        return DaggerActivityComponent.builder()
                .appComponent(BaseApplication.getAppComponent())
                .activityModule(getActivityModule())
                .build()
    }

    private fun getActivityModule(): ActivityModule {
        return ActivityModule(this)
    }

    override fun onCreateView() {
        super.onCreateView()
        setInject()
//        presenter?.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.detachView()
    }
}
