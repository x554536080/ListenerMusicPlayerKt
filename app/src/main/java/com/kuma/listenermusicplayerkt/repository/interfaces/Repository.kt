package com.kuma.listenermusicplayerkt.repository.interfaces

import com.kuma.listenermusicplayerkt.api.model.ArtistInfo
import rx.Observable

/**
 * name: Repository
 * author: 熊熊熊
 * date: 2022/10/13 1:22
 * description:
 */
interface Repository {
    //from network
     fun getArtistInfo(artist: String): Observable<ArtistInfo>

    //from local
}