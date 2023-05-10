package com.kuma.listenermusicplayerkt.injector.module

import com.kuma.listenermusicplayerkt.mvp.contract.ArtistDetailContract
import com.kuma.listenermusicplayerkt.mvp.presenter.ArtistDetailPresenter
import com.kuma.listenermusicplayerkt.mvp.usecase.GetArtistInfo
import com.kuma.listenermusicplayerkt.repository.interfaces.Repository
import dagger.Provides

/**
 * 这个类的主要两个作用一个是提供adapter使用的useCase供列表歌手详细信息展示，一个是提供歌手详细页加载歌手图片等的presenter
 * （不过没懂为啥整成了一个module，或者说为什么不连同artist的那个整合在一起
 */
class ArtistInfoModule {

    @Provides
    fun getArtistInfoUsecase(repository: Repository): GetArtistInfo {
        return GetArtistInfo(repository)
    }

    @Provides
    fun getArtistDetailPresenter(): ArtistDetailContract.Presenter {
        return ArtistDetailPresenter()
    }
}