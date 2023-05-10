package com.kuma.listenermusicplayerkt.mvp.usecase

import com.kuma.listenermusicplayerkt.api.model.ArtistInfo
import com.kuma.listenermusicplayerkt.repository.interfaces.Repository
import rx.Observable

class GetArtistInfo(private val mRepository: Repository) :
    UseCase<GetArtistInfo.RequestValues, GetArtistInfo.RespondValue>() {

    override fun execute(requestValues: RequestValues): RespondValue {
        return RespondValue(mRepository.getArtistInfo(requestValues.artistName))
    }

    class RequestValues(val artistName: String) : UseCase.RequestValues

    class RespondValue(val artistInfoObservable: Observable<ArtistInfo>) :
        UseCase.RespondValue
}