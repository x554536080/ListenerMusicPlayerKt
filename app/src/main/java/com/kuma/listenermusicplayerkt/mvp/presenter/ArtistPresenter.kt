package com.kuma.listenermusicplayerkt.mvp.presenter

import com.kuma.listenermusicplayerkt.mvp.contract.ArtistContract
import com.kuma.listenermusicplayerkt.mvp.usecase.GetArtists
import com.kuma.listenermusicplayerkt.mvp.view.BaseView
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ArtistPresenter(val getArtists: GetArtists) : ArtistContract.Presenter {

    private lateinit var mView: ArtistContract.View

    override fun loadArtist(action: String) {
        getArtists.execute(GetArtists.RequestValues(action))
            .getArtistList()!!
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {  }
    }

    override fun attachView(baseView: BaseView) {
        mView = baseView as ArtistContract.View//妈的谁说那个泛型没意义了 只能这么写吗
    }

    override fun subscribe() {
        TODO("Not yet implemented")
    }

    override fun unsubscribe() {
        TODO("Not yet implemented")
    }
}