package com.kuma.listenermusicplayerkt.mvp.contract

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.kuma.listenermusicplayerkt.mvp.presenter.BasePresenter
import com.kuma.listenermusicplayerkt.mvp.view.BaseView

interface ArtistDetailContract {
    interface View : BaseView {
        fun getContext(): Context?//ta这个方法是用来presenter里glide 、sp什么的用的 没有更好的办法？
        fun showArtistArt(drawable: Drawable)
        fun showArtistArt(bitmap: Bitmap)
    }

    interface Presenter : BasePresenter {
        fun subscribe(id:Long)//醉醉的，作者subscribe这个方法里面就一个loadArtistArt的方法
        fun loadArtistArt(id: Long)
    }
}