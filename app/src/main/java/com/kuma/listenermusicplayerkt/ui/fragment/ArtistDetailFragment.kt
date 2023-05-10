package com.kuma.listenermusicplayerkt.ui.fragment

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.fragment.app.Fragment
import com.kuma.listenermusicplayerkt.ListenerApp
import com.kuma.listenermusicplayerkt.mvp.contract.ArtistDetailContract
import javax.inject.Inject

class ArtistDetailFragment : Fragment(), ArtistDetailContract.View {
    //诶 为了写好接口Context的返回值之后再来写后面实现的接口强迫症，忘了之前写了多少了，这是强迫症今天强迫症最烦的时候了，诶那去玩会游戏吧 买下机票也可以了

    @Inject
    @JvmField
    var mPresenter: ArtistDetailContract.Presenter? = null

    private fun injectDependencies() {
        val applicationComponent = (activity?.application as ListenerApp).getApplicationComponent()
        //5.6 之前没在manifest里面注册，artistFragment里的inject没问题吗


    }

    override fun showArtistArt(drawable: Drawable) {
        TODO("Not yet implemented")
    }

    override fun showArtistArt(bitmap: Bitmap) {
        TODO("Not yet implemented")
    }
}