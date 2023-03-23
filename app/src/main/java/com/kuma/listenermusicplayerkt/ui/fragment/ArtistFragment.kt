package com.kuma.listenermusicplayerkt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kuma.listenermusicplayerkt.mvp.contract.ArtistContract
import com.kuma.listenermusicplayerkt.mvp.module.Artist
import javax.inject.Inject

class ArtistFragment : Fragment(), ArtistContract.View {

    @Inject
    var mPresenter: ArtistContract.Presenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
    }

    private fun injectDependencies() {


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        val rootView = inflater.inflate()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun showArtist(artists: List<Artist?>?) {
        TODO("Not yet implemented")
    }

    override fun showEmptyView() {
        TODO("Not yet implemented")
    }

    companion object {
        fun newInstance(action: String): ArtistFragment {
            //ignore bundle
            //ignore action judge

            val fragment = ArtistFragment()
            //
            return fragment
        }
    }
}