package com.kuma.listenermusicplayerkt.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.navigation.NavigationView
import com.kuma.listenermusicplayerkt.R
import com.kuma.listenermusicplayerkt.util.ListenerUtil
import com.sothree.slidinguppanel.SlidingUpPanelLayout

class MainActivity : AppCompatActivity() {

    @BindView(R.id.sliding_layout)
    lateinit var panelLayout: SlidingUpPanelLayout

    @BindView(R.id.nav_view)
    lateinit var navigationView: NavigationView

    @BindView(R.id.drawer_layout)
    lateinit var mDrawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        if (ListenerUtil.isMarshmallow()) {
        //permission} else {

        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

private fun loadEveryThing(){

}
}