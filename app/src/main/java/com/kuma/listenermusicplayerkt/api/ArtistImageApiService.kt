package com.kuma.listenermusicplayerkt.api

import com.kuma.listenermusicplayerkt.api.model.ArtistInfo
import rx.Observable

/**
 * name: ArtistImageApiService
 * author: 熊熊熊
 * date: 2022/10/13 13:51
 * description:
 */
class ArtistImageApiService {

val BASE_PARAMATERS_ARTIST:String = "pic.web?type=big_artist_pic&pictype=url&content=list&&id=0&from=pc&json=1&version=1&width=240&height=240"

fun getArtistInfo():Observable<ArtistInfo>?{return null}}
