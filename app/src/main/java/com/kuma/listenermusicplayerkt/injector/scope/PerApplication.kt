package com.kuma.listenermusicplayerkt.injector.scope

import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)//有意思
annotation class PerApplication()
