package com.kuma.listenermusicplayerkt.mvp.contract

import com.kuma.listenermusicplayerkt.mvp.module.Artist
import com.kuma.listenermusicplayerkt.mvp.presenter.BasePresenter
import com.kuma.listenermusicplayerkt.mvp.view.BaseView

interface ArtistContract {
    interface View : BaseView {
        //todo kotlin的集合相关的 到现在也没有系统的清楚，可能是这个的原因 需要对记忆的整理所以突然有点yy吧， 唉想说什么突然又忘了 是之前上次学kotlin知识的时候还是在21年？ 20年？
        fun showArtist(artists: List<Artist>)
        fun showEmptyView()
    }

    interface Presenter : BasePresenter {
        fun loadArtist(action: String)
    }
}