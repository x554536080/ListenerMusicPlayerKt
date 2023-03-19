package com.kuma.listenermusicplayerkt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.afollestad.appthemeengine.ATE
import com.kuma.listenermusicplayerkt.Constants
import com.kuma.listenermusicplayerkt.R

class MainFragment : Fragment() {
    @JvmField
    @BindView(R.id.viewpager)
    var viewPager:ViewPager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        ATE.apply(this,)

        ButterKnife.bind(this, view)


        setupViewPager(viewPager)
    }

    private fun setupViewPager(viewPager: ViewPager?) {


    }


    companion object {
        fun newInstance(action: String?): MainFragment {
            val mainFragment = MainFragment()
            val bundle = Bundle()
            when (action) {
                Constants.NAVIGATE_ALLSONG -> bundle.putString(Constants.PLAYLIST_TYPE, action)
            }
            mainFragment.arguments = bundle
            return mainFragment
        }
    }
}