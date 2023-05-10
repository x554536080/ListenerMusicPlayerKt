package com.kuma.listenermusicplayerkt.injector.component

import com.kuma.listenermusicplayerkt.injector.module.ArtistInfoModule
import com.kuma.listenermusicplayerkt.injector.scope.PerActivity
import dagger.Component

/**
 * 这个类的
 */
@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ArtistInfoModule::class])
interface ArtistInfoComponent {


}