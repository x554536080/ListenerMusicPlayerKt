package com.kuma.listenermusicplayerkt.mvp.usecase

import com.kuma.listenermusicplayerkt.Constants
import com.kuma.listenermusicplayerkt.mvp.module.Artist
import com.kuma.listenermusicplayerkt.repository.interfaces.Repository
import rx.Observable

class GetArtists(val mRepository: Repository?) :
    UseCase<GetArtists.RequestValues, GetArtists.RespondValue>() {


    override fun execute(requestValues: RequestValues): RespondValue {
        val action = requestValues.action


        when (action) {
            Constants.NAVIGATE_ALLSONG ->
                return RespondValue(mRepository?.getAllArtists())

            else -> throw java.lang.RuntimeException("wrong action type")
//                return RespondValues(Observable.create(object : Observable.OnSubscribe<List<Artist>> {
//                    override fun call(t: Subscriber<in List<Artist>>?) {
//                        val arrayList: List<Artist> = ArrayList()
//
//
//                        t?.onNext(arrayList)
//                        t?.onCompleted()
//                    }
//                }))
//
//                return RespondValues(
//                getArtistsForCursor(
//                    markArtistsCursor(
//                        context,
//                        null,
//                        null
//                    )
//                )
//            )

        }

    }

    class RequestValues(val action: String) : UseCase.RequestValues

    class RespondValue(val mListObservable: Observable<List<Artist>>?) :
        UseCase.RespondValue {
        fun getArtistList(): Observable<List<Artist>>? {
            return mListObservable
        }
    }

}