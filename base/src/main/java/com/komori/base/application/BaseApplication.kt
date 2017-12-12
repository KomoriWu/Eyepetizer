package com.komori.base.application

import android.app.Activity
import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.komori.base.BuildConfig
import com.komori.base.di.component.AppComponent
import com.komori.base.di.component.DaggerAppComponent
import com.komori.base.di.module.AppModule
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import java.util.*


/**
 * Created by KomoriWu
 * on 2017-12-12.
 */

open  class BaseApplication : Application() {
    private var mActivityList: ArrayList<Activity>? = null

    override fun onCreate() {
        super.onCreate()
        if (sInstance == null) {
            sInstance = this
        }
        mActivityList = ArrayList()
    }

    fun addActivity(activity: Activity) {
        if (!mActivityList!!.contains(activity)) {
            mActivityList!!.add(activity)
        }
    }


    fun removeAllActivity() {
        for (activity in mActivityList!!) {
            activity.finish()
        }
        android.os.Process.killProcess(android.os.Process.myPid())
        System.exit(0)
    }

    companion object {
        private var sImageLoader: ImageLoader? = null
        private var sInstance: BaseApplication? = null
        private var sAppComponent: AppComponent? = null

        fun getImageLoader(context: Context): ImageLoader? {
            if (sImageLoader == null) {
                synchronized(ImageLoader::class) {
                    if (sImageLoader == null) {
                        sImageLoader = ImageLoader.getInstance()
                        sImageLoader!!.init(ImageLoaderConfiguration.createDefault(context.
                                applicationContext))
                    }
                }
            }
            return sImageLoader
        }

        fun getInstance(): BaseApplication {
            return if (sInstance == null) {
                BaseApplication();
            } else {
                sInstance as BaseApplication;
            }
        }

        fun getAppComponent(): AppComponent? {
            if (sAppComponent == null) {
                sAppComponent = DaggerAppComponent.builder()
                        .appModule(AppModule(sInstance!!))
                        .build()
            }
            return sAppComponent
        }

        fun initRouter(application: Application) {
            if (BuildConfig.DEBUG) {
                ARouter.openLog()
                ARouter.openDebug()
            }
            ARouter.init(application)
        }
    }
}
