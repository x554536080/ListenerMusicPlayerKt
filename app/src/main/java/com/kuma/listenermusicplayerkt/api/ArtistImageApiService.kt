package com.kuma.listenermusicplayerkt.api

import com.kuma.listenermusicplayerkt.api.model.ArtistInfo
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * name: ArtistImageApiService
 * author: 熊熊熊
 * date: 2022/10/13 13:51
 * description:
 */
interface ArtistImageApiService {

    companion object {
        const val BASE_PARAMATERS_ARTIST: String =
            "pic.web?type=big_artist_pic&pictype=url&content=list&&id=0&from=pc" +
                    "&json=1&version=1&width=240&height=240"
    }

    @GET(BASE_PARAMATERS_ARTIST)
    fun getArtistInfo(@Query("artist") artist: String): Observable<ArtistInfo>
}
