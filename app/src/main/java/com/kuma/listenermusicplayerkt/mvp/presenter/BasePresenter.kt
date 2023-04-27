package com.kuma.listenermusicplayerkt.mvp.presenter

import com.kuma.listenermusicplayerkt.mvp.view.BaseView

interface BasePresenter {
    //todo 好像作者那个泛型没什么意义
    //或者就是强调一下这个对应关系？说明contract里面的view必须继承自baseView？

    fun attachView(baseView: BaseView)

    fun subscribe()

    fun unsubscribe()
}