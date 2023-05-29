package com.kuma.listenermusicplayerkt.util

import android.content.Context
import android.content.SharedPreferences

class PreferencesUtility(val context: Context) {

    companion object {
        private val ARTIST_ART_URL = "artist_at_url_"

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


    fun setArtistArt(artistId: Long, jsonString: String) {
        val editor = mPreferences?.edit()
        editor?.putString(ARTIST_ART_URL + artistId, jsonString)
        editor?.apply()
    }
}