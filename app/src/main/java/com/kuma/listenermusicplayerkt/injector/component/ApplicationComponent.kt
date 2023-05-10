package com.kuma.listenermusicplayerkt.injector.component

import android.app.Application
import com.kuma.listenermusicplayerkt.ListenerApp
import com.kuma.listenermusicplayerkt.injector.module.ApplicationModule
import com.kuma.listenermusicplayerkt.injector.module.NetworkModule
import com.kuma.listenermusicplayerkt.injector.scope.PerApplication
import com.kuma.listenermusicplayerkt.repository.interfaces.Repository
import dagger.Component

@Component(modules = [ApplicationModule::class, NetworkModule::class])//为毛这里不能.java了，研究个P
@PerApplication
interface ApplicationComponent {
// kyuukyoku疑问，dependencies component不需要 写 inject方法吗，如果没有直接的使用来注入依赖的话
// 怎么说呢 就是，一般的component都要在注入的类里调用inject方法嘛，这边没调and最终也没调的话应该就是给其他component依赖了


// 然后就是最大的问题again 他原来写的 这个类里面的ListenerApp listenerApplication(); 是干嘛用的
// 而且特么的名字写对了 还可以点击正确跳转

    //todo 基本上两方面总结解决问题了 1module中的provide方法也可以给module内部的方法的形参使用 2如果是跨module的依赖 需要在被依赖的component中声明
    //todo 不确定，但是这么解释可以解释的通。。。。这个没咋在网上教程里看到过 可能是没咋看dependencies的部分
    fun listenerApplication(): ListenerApp
//
//    fun application():Application

    fun repository(): Repository?
}