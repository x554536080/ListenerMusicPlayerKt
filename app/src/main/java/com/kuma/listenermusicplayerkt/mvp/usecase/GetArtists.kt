package com.kuma.listenermusicplayerkt.mvp.usecase

import android.content.Context
import com.kuma.listenermusicplayerkt.Constants
import com.kuma.listenermusicplayerkt.mvp.module.Artist
import rx.Observable

class GetArtists(val context: Context) :
    UseCase<GetArtists.RequestValues, GetArtists.RespondValues>() {


    override fun execute(requestValues: RequestValues): RespondValues {
        val action = requestValues.action
//        when (action) {
//            Constants.NAVIGATE_ALLSONG -> return RespondValues(
//                getArtistsForCursor(
//                    markArtistsCursor(
//                        context,
//                        null,
//                        null
//                    )
//                )
//            )
//        }
        return RespondValues(null)
    }

    class RequestValues(val action: String) : UseCase.RequestValues

    class RespondValues(val mListObservable: Observable<List<Artist>>?) : UseCase.RespondValues {
        fun getArtistList(): Observable<List<Artist>>? {
            return mListObservable
        }
    }

}