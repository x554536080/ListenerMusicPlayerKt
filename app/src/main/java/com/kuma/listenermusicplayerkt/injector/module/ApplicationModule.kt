package com.kuma.listenermusicplayerkt.injector.module

import android.app.Application
import com.kuma.listenermusicplayerkt.ListenerApp
import com.kuma.listenermusicplayerkt.injector.scope.PerApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val mListenerApp: ListenerApp) {

    @Provides
    @PerApplication
    fun provideListenerApp(): ListenerApp {
        return mListenerApp
        //todo 实在是没懂太这个方法是用来干什么的

        //写demo代码可以用 hhh 可能之前也是后面保留了方法
    }
//
//    @Provides
//    @PerApplication
//    fun provideApplication(): Application {
//        return mListenerApp
//    }

    //本来下面还有个provideApplication一眼 样 的方法，我觉得没必要写了吧
}