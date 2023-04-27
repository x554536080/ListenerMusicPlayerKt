package com.kuma.listenermusicplayerkt.util

import android.content.Context
import android.content.SharedPreferences

class PreferencesUtility(val context: Context) {

    companion object {
        private var sInstance: PreferencesUtility? = null

        @Volatile
        private var mPreferences: SharedPreferences? = null

        fun getInstance(context: Context): PreferencesUtility? {
            if (sInstance == null) {
                synchronized(PreferencesUtility::class.java) {
                    if (sInstance == null) {
                        sInstance = PreferencesUtility(context)
                    }
                }
            }
            return sInstance
        }


    }
}