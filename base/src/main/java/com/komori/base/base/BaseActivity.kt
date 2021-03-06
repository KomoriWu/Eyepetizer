package com.komori.base.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.KeyEvent
import android.widget.Toast
import com.komori.base.R
import com.komori.base.application.BaseApplication
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.toolbar

abstract class BaseActivity : AppCompatActivity() {
    var isBack = true
    private var mExitTime: Long = 0
    private var mApplication: BaseApplication? = null
    abstract val layoutId: Int

    var onMenuItemClick: Toolbar.OnMenuItemClickListener = Toolbar.OnMenuItemClickListener { menuItem ->
        OnMenuItemClick(menuItem.itemId)
        true
    }

    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
//        ButterKnife.bind(this)
        mApplication = BaseApplication.getInstance()
        addActivity()
        onCreateView()
        init()
    }

    open fun onCreateView() {

    }


    fun initToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        title = ""
        toolbar?.setOnMenuItemClickListener(onMenuItemClick)

        if (isBack) {
            toolbar?.setNavigationOnClickListener { onBackPressed() }
        }

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    fun OnMenuItemClick(itemId: Int) {

    }

    fun onExitActivity(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - mExitTime > 2000) {
                Toast.makeText(this, R.string.exit_program_hint,
                        Toast.LENGTH_SHORT).show()
                mExitTime = System.currentTimeMillis()
            } else {
                removeAllActivity()
            }
            true
        } else {
            super.onKeyDown(keyCode, event)
        }
    }

    public override fun onDestroy() {
        super.onDestroy()
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }

    fun addActivity() {
        mApplication!!.addActivity(this)
    }


    fun removeAllActivity() {
        mApplication!!.removeAllActivity()
    }

    @Subscribe
    fun onEventMainThread() {
    }
}
