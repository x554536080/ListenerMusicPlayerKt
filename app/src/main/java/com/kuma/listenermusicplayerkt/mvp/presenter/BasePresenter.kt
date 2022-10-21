package com.kuma.listenermusicplayerkt.mvp.presenter

import com.kuma.listenermusicplayerkt.mvp.view.BaseView

interface BasePresenter {
fun attachView(baseView: BaseView)

fun subscribe()

fun unsubscribe()
}