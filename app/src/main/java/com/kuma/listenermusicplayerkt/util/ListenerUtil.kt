package com.kuma.listenermusicplayerkt.util

import android.annotation.TargetApi
import android.content.res.Resources
import android.os.Build
import android.view.View

object ListenerUtil {
    fun isMarshmallow(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
    }

    @JvmStatic
//    @TargetApi todo 这个。。。
    fun isRtl(res: Resources): Boolean {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) and
                (res.configuration.layoutDirection == View.LAYOUT_DIRECTION_RTL)
    }
}