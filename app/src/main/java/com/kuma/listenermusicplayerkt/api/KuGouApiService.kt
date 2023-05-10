package com.kuma.listenermusicplayerkt.api

import com.kuma.listenermusicplayerkt.api.model.ArtistInfo
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable


interface KuGouApiService {


    @GET()
    fun searchLyric(@Query("keyword") songName: String): Observable<ArtistInfo>? {
        return null
    }

    fun getRawLyric() {}

}
