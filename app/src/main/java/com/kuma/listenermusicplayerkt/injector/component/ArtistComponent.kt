package com.kuma.listenermusicplayerkt.injector.component

import com.kuma.listenermusicplayerkt.injector.module.ArtistModule
import com.kuma.listenermusicplayerkt.injector.scope.PerActivity
import com.kuma.listenermusicplayerkt.ui.fragment.ArtistFragment
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ArtistModule::class])
//kotlin里面这个dependencies就是必须要打中括号的嘛
interface ArtistComponent {
    fun inject(artistFragment: ArtistFragment?)
}