package com.kuma.listenermusicplayerkt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import butterknife.BindView
import butterknife.ButterKnife
import com.kuma.listenermusicplayerkt.Constants
import com.kuma.listenermusicplayerkt.ListenerApp
import com.kuma.listenermusicplayerkt.R
import com.kuma.listenermusicplayerkt.injector.component.DaggerArtistComponent
import com.kuma.listenermusicplayerkt.injector.module.ArtistModule
import com.kuma.listenermusicplayerkt.mvp.contract.ArtistContract
import com.kuma.listenermusicplayerkt.mvp.module.Artist
import com.kuma.listenermusicplayerkt.util.PreferencesUtility
import com.kuma.listenermusicplayerkt.widget.fastscroller.FastScrollRecyclerView
import javax.inject.Inject

class ArtistFragment : Fragment(), ArtistContract.View {

    @Inject
    @JvmField//有无其他解决办法？
    public var mPresenter: ArtistContract.Presenter? = null//声明类型写AP和AC.P有什么区别 和Dagger上

    @BindView(R.id.recyclerview)
    @JvmField
    var recyclerView: FastScrollRecyclerView? = null

    @BindView(R.id.view_empty)
    @JvmField
    var emptyView: View? = null

private var mAdapter:Ada

    private var mPreferences: PreferencesUtility? = null

    private var layoutManager: GridLayoutManager? = null

    private var isGrid = false

    private lateinit var action: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        mPresenter?.attachView(this)
        if (isGrid) {
        } else {
        }

        action = arguments?.getString(Constants.PLAYLIST_TYPE)!!


    }

    private fun injectDependencies() {
        val applicationComponent =
            (requireActivity().application as ListenerApp).getApplicationComponent()
        val artistComponent = DaggerArtistComponent.builder()
            .applicationComponent(applicationComponent)
            .artistModule(ArtistModule())
            .build()
        artistComponent.inject(this)//总感觉这个写法有种说不出来的怪
        //我突然在想kotlin 是什么时候才能用直接.成员的方法get成员变量
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_recyclerview, container, false)
        ButterKnife.bind(this, rootView)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter?.loadArtist(action)
    }


    override fun showArtist(artists: List<Artist?>?) {

    }

    override fun showEmptyView() {
        emptyView?.visibility = View.VISIBLE
    }

    companion object {
        fun newInstance(action: String): ArtistFragment {
            //ignore bundle
            //ignore action judge


            val fragment = ArtistFragment()
            val bundle = Bundle()
            when (action) {
                Constants.NAVIGATE_ALLSONG -> bundle.putString(Constants.PLAYLIST_TYPE, action)
            }
            fragment.arguments = bundle

            //
            return fragment
        }
    }
}