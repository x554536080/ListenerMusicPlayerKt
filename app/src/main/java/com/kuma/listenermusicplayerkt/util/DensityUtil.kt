package com.kuma.listenermusicplayerkt.util

import android.content.Context
import android.util.TypedValue

object DensityUtil {

    @JvmStatic
    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt() //0.5f ?
    }//总之 就是为了不修改fast scroller java类中的代码，就加上static的注解吧



    @JvmStatic
    fun dip2sp(context: Context, sp: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            sp,
            context.resources.displayMetrics
        ).toInt()
    }//这应该是dp吧。。。。
}