package com.kuma.listenermusicplayerkt.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.navigation.NavigationView
import com.kuma.listenermusicplayerkt.Constants
import com.kuma.listenermusicplayerkt.R
import com.kuma.listenermusicplayerkt.ui.fragment.MainFragment
import com.kuma.listenermusicplayerkt.util.ListenerUtil
import com.sothree.slidinguppanel.SlidingUpPanelLayout

class MainActivity : BaseActivity() {

    @BindView(R.id.sliding_layout)
    lateinit var panelLayout: SlidingUpPanelLayout

    @JvmField
    @BindView(R.id.nav_view)
     var navigationView: NavigationView? = null

    @BindView(R.id.drawer_layout)
    lateinit var mDrawerLayout: DrawerLayout


    private val navigateLibrary = Runnable {
        navigationView!!.menu.findItem(R.id.nav_library).isChecked = true
        val fragment = MainFragment.newInstance(Constants.NAVIGATE_ALLSONG)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        //权限真的是一件听麻烦的事 先不管了，不是说麻烦 就是学习期间懒得管很不想管
        if (ListenerUtil.isMarshmallow()) {
            //permission} else {

            //hh我笑死 刚好上面之前也注释掉了 就先懒得管吧
            loadEveryThing()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun loadEveryThing() {
//源码中有个navigationMap.get(action)也是见鬼，看不懂想写什么
        navigateLibrary.run()

    }


}