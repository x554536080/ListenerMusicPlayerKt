package com.kuma.listenermusicplayerkt.repository

import android.content.Context
import android.provider.MediaStore
import com.kuma.listenermusicplayerkt.api.ArtistImageApiService
import com.kuma.listenermusicplayerkt.api.KuGouApiService
import com.kuma.listenermusicplayerkt.api.LastFmApiService
import com.kuma.listenermusicplayerkt.api.model.ArtistInfo
import com.kuma.listenermusicplayerkt.mvp.module.Artist
import com.kuma.listenermusicplayerkt.repository.interfaces.Repository
import retrofit2.Retrofit
import rx.Observable

/**
 * name: RepositoryImpl
 * author: 熊熊熊
 * date: 2022/10/13 1:23
 * description:
 */

//之前为啥写的是abstract
class RepositoryImpl(context: Context, artistImage: Retrofit, kugou: Retrofit, lastfm: Retrofit?) :
    Repository {
    private var mArtistImageApiService: ArtistImageApiService

    private var mKuGouApoService: KuGouApiService

    private var mLastFmApiService: LastFmApiService?

    private var mContext: Context

    init {
        mContext = context
        mArtistImageApiService = artistImage.create(ArtistImageApiService::class.java)
        mKuGouApoService = kugou.create(KuGouApiService::class.java)
        mLastFmApiService = lastfm?.create(LastFmApiService::class.java)
    }

    override fun getArtistInfo(artist: String): Observable<ArtistInfo> {
        //从这里开始lastfm完全变成kuwo
        return mArtistImageApiService.getArtistInfo(artist)
    }


    override fun getAllArtists(): Observable<List<Artist>> {
        val cursor = mContext.contentResolver.query(
            MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
            arrayOf("_id", "artist", "number_of_albums", "number_of_tracks"),
            null,
            null,
            MediaStore.Audio.Artists.DEFAULT_SORT_ORDER
        )

        return Observable.create {
            var arrayList: MutableList<Artist> = ArrayList()
            if (cursor != null && cursor.moveToFirst())
                do {
                    arrayList.add(
                        Artist(
                            cursor.getInt(2),
                            cursor.getLong(0),
                            cursor.getString(1),
                            cursor.getInt(3)
                        )//要命了 原来的成员顺序和构造器参数顺序不同 btw 拷贝转的代码and me有什么问题...
                    )
                } while (cursor.moveToNext())
            if (cursor != null) cursor.close()
            it.onNext(arrayList)
//            it.onCompleted() 这行是不是可以没必要不要
        }
    }
}