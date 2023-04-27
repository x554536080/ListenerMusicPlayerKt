package com.kuma.listenermusicplayerkt.util

import android.content.Context
import android.preference.PreferenceManager
import com.afollestad.appthemeengine.Config

object ATEUtil {

    @JvmStatic
    //这个Key是搞木子用的
    private fun getATEKey(context: Context): String? {
        return if (PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean("dark_theme", false)
        ) "dark_theme" else "light_theme"
    }

    @JvmStatic
    fun getThemePrimaryColor(context: Context): Int {
        return Config.primaryColor(context, getATEKey(context))
    }


}