package com.kuma.listenermusicplayerkt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.afollestad.appthemeengine.ATE
import com.google.android.material.tabs.TabLayout
import com.kuma.listenermusicplayerkt.Constants
import com.kuma.listenermusicplayerkt.R

class MainFragment : Fragment() {
    @JvmField
    @BindView(R.id.toolbar)
    var toolbar: Toolbar? = null

    @JvmField
    @BindView(R.id.tabs)
    var tabLayout: TabLayout? = null

    @JvmField
    @BindView(R.id.viewpager)
    var viewPager: ViewPager? = null

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

//        (activity as AppCompatActivity)!!.supportActionBar = toolbar
//        (activity as AppCompatActivity)!!.setSupportActionBar(toolbar)


        tabLayout!!.setupWithViewPager(viewPager)
        if (viewPager != null) setupViewPager(viewPager)

    }

    private fun setupViewPager(viewPager: ViewPager?) {
        val adapter = Adapter(childFragmentManager)
        adapter.addFragment(Fragment(), "歌曲")
        adapter.addFragment(Fragment(), "歌手")
        adapter.addFragment(Fragment(), "专辑")
        viewPager!!.adapter = adapter
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

        class Adapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
            private val fragments: MutableList<Fragment> = ArrayList()
            private val fragmentTitles: MutableList<String> = ArrayList()
            fun addFragment(fragment: Fragment, title: String) {
                fragments.add(fragment)
                fragmentTitles.add(title)
            }

            override fun getCount(): Int {
                return fragments.size
                //todo ？？？不是不需要打return吗？
            }

            override fun getItem(position: Int): Fragment {
                return  fragments[position]
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return fragmentTitles[position]
            }
        }
    }
}