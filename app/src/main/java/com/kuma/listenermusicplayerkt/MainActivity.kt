package com.kuma.listenermusicplayerkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.navigation.NavigationView
import com.sothree.slidinguppanel.SlidingUpPanelLayout

class MainActivity : AppCompatActivity() {

    @BindView(R.id.sliding_layout)
    lateinit var panelLayout:SlidingUpPanelLayout
    @BindView(R.id.nav_view)
    lateinit var navigationView: NavigationView
    @BindView(R.id.drawer_layout)
    lateinit var mDrawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }
}