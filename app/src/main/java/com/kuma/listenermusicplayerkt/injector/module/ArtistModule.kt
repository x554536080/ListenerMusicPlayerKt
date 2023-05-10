package com.kuma.listenermusicplayerkt.injector.module

import android.content.Context
import com.kuma.listenermusicplayerkt.ListenerApp
import com.kuma.listenermusicplayerkt.mvp.contract.ArtistContract
import com.kuma.listenermusicplayerkt.mvp.presenter.ArtistPresenter
import com.kuma.listenermusicplayerkt.mvp.usecase.GetArtists
import com.kuma.listenermusicplayerkt.repository.interfaces.Repository
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @Provides//todo 这个方法的名称没有什么特殊规则是吧 我就写provideXXX那应该也没什么是吧
    fun provideArtistPresenter(getArtists: GetArtists): ArtistContract.Presenter {
        return ArtistPresenter(getArtists)
    }

    @Provides
    fun getArtistsUseCase(repository: Repository?): GetArtists {
        return GetArtists(repository)//继续新代码 可以换成repository了
    }

}