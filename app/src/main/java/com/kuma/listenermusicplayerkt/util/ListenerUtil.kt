package com.kuma.listenermusicplayerkt.util

import android.os.Build

object ListenerUtil {
    fun isMarshmallow(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
    }
}