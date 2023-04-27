package com.kuma.listenermusicplayerkt.mvp.usecase

abstract class UseCase<Q : UseCase.RequestValues, P : UseCase.RespondValues> {

    private var mRequestValue: Q? = null

//这两个方法在项目里好像也是没用到过
//    fun setRequestValues(requestValues: Q) {
//        mRequestValue = requestValues
//    }
//
//    fun getRequestValues(): RequestValues? {
//        return mRequestValue
//    }

    abstract fun execute(q: Q): P

    interface RequestValues

    interface RespondValues//所以这两个接口有什么数据格式上的意义...其实就是模式上的设定吧
}