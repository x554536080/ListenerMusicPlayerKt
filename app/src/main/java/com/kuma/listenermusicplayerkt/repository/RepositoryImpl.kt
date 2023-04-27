package com.kuma.listenermusicplayerkt.repository

import android.content.Context
import com.kuma.listenermusicplayerkt.api.ArtistImageApiService
import com.kuma.listenermusicplayerkt.api.model.ArtistInfo
import com.kuma.listenermusicplayerkt.repository.interfaces.Repository
import retrofit2.Retrofit
import rx.Observable

/**
 * name: RepositoryImpl
 * author: 熊熊熊
 * date: 2022/10/13 1:23
 * description:
 */
abstract class RepositoryImpl(mContext: Context, artistImage: Retrofit) : Repository {
    lateinit var mArtistImageApiService: ArtistImageApiService
    init {
        mArtistImageApiService = artistImage.create(ArtistImageApiService::class.java)
    }

}