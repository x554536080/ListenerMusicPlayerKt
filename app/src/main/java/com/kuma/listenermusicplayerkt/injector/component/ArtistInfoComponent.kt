package com.kuma.listenermusicplayerkt.injector.component

import com.kuma.listenermusicplayerkt.injector.module.ArtistInfoModule
import com.kuma.listenermusicplayerkt.injector.scope.PerActivity
import com.kuma.listenermusicplayerkt.ui.adapter.ArtistAdapter
import com.kuma.listenermusicplayerkt.ui.fragment.ArtistDetailFragment
import dagger.Component

/**
 * 这个类的
 */
@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ArtistInfoModule::class])
interface ArtistInfoComponent {

    fun injectForAdapter(artistAdapter: ArtistAdapter)

    fun injectForFragment(artistDetailFragment: ArtistDetailFragment)
}