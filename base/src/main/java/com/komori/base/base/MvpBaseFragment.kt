package com.komori.base.base


import android.os.Bundle
import android.view.View
import com.komori.base.application.BaseApplication
import com.komori.base.di.component.DaggerFragmentComponent
import com.komori.base.di.component.FragmentComponent
import com.komori.base.di.module.FragmentModule
import javax.inject.Inject

/**
 * Created by KomoriWu
 * on 2017-11-30.
 */


abstract class MvpBaseFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {
    @JvmField
    @Inject
    var presenter: T? = null

    fun getFragmentComponent(): FragmentComponent {
        return DaggerFragmentComponent.builder()
                .appComponent(BaseApplication.getAppComponent())
                .fragmentModule(fragmentModule)
                .build()
    }


    private val fragmentModule: FragmentModule
        get() = FragmentModule(this)

    protected abstract fun initInject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initInject()
        if (presenter != null) {
//            presenter!!.attachView(this)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (presenter != null) {
            presenter!!.detachView()
        }
    }
}
