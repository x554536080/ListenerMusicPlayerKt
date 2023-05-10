package com.kuma.listenermusicplayerkt.mvp.presenter

import com.kuma.listenermusicplayerkt.mvp.contract.ArtistContract
import com.kuma.listenermusicplayerkt.mvp.usecase.GetArtists
import com.kuma.listenermusicplayerkt.mvp.view.BaseView
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ArtistPresenter(val mUsecase: GetArtists) : ArtistContract.Presenter {

    private var mView: ArtistContract.View? = null

    override fun loadArtist(action: String) {
        mUsecase.execute(GetArtists.RequestValues(action))
            .getArtistList()!!
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                if (it == null || it.isEmpty()) {
                    mView?.showEmptyView()
                } else {
                    mView?.showArtist(it)
                }
            }
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