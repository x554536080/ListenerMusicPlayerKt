package com.kuma.listenermusicplayerkt.util

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kuma.listenermusicplayerkt.R

class NavigationUtil {

    companion object {

        @JvmStatic
        fun navigateToArtist(
            context: Activity,
            artistId: Long,
            name: String,
            transitionViews: Pair<View, String>
        ) {
            val transaction =
                (context as AppCompatActivity).supportFragmentManager.beginTransaction()

            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP &&
                transitionViews != null
            ) {

            } else {

            }
            transaction.hide(
                (context as AppCompatActivity).supportFragmentManager.findFragmentById(
                    R.id.fragment_container
                )!!
            )



        }


    }

}