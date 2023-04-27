package com.kuma.listenermusicplayerkt

import android.app.Application
import com.kuma.listenermusicplayerkt.injector.component.ApplicationComponent
import com.kuma.listenermusicplayerkt.injector.component.DaggerApplicationComponent
import com.kuma.listenermusicplayerkt.injector.module.ApplicationModule
import com.kuma.listenermusicplayerkt.injector.module.NetworkModule

class ListenerApp : Application() {

    private var mApplicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        setupInjector()
    }

    private fun setupInjector() {
        //下午想说啥来着，这样写一下差不多就会熟悉很多是吧 吧是
        mApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .networkModule(NetworkModule(this)).build()
    }

    fun getApplicationComponent(): ApplicationComponent? {
        return mApplicationComponent
    }
}