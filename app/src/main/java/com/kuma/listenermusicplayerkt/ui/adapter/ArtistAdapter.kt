package com.kuma.listenermusicplayerkt.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kuma.listenermusicplayerkt.ListenerApp
import com.kuma.listenermusicplayerkt.R
import com.kuma.listenermusicplayerkt.injector.component.ArtistInfoComponent
import com.kuma.listenermusicplayerkt.injector.component.DaggerArtistInfoComponent
import com.kuma.listenermusicplayerkt.injector.module.ArtistInfoModule
import com.kuma.listenermusicplayerkt.mvp.module.Artist
import com.kuma.listenermusicplayerkt.mvp.usecase.GetArtistInfo
import javax.inject.Inject

class ArtistAdapter(context: Activity?, action: String) :
    RecyclerView.Adapter<ArtistAdapter.ItemHolder>() {
//什么时候不用管构造函数的？

    init {
        injectDependencies(context)
    }

    @Inject
    @JvmField
    var getArtistInfo :GetArtistInfo? = null

    //一个记忆点 retrofit创建request就有两种方式 一种call 一种observable

    private var arraylist: List<Artist>? = null

    private var isGrid = false

    private fun injectDependencies(context: Activity?) {
        val applicationComponent = (context?.application as ListenerApp).getApplicationComponent()
        val artistInfoComponent = DaggerArtistInfoComponent.builder()
            .applicationComponent(applicationComponent)
            .artistInfoModule(ArtistInfoModule())
            .build()
        artistInfoComponent.injectForAdapter(this)
    }

    fun setArtistList(arraylist: List<Artist>) {
        this.arraylist = arraylist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        if (isGrid) {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_grid_layout_item, parent, false)
            return ItemHolder(v)
        } else {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_linear_layout_item, parent, false)
            return ItemHolder(v)
        }
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val localItem = arraylist?.get(position)
        holder.name?.text = localItem?.name
        holder.albumCount?.text = localItem?.albumCount.toString()
        holder.songCount?.text = localItem?.songCount.toString()
    }

    override fun getItemCount(): Int {
        return if (null != arraylist) arraylist!!.size else 0
    }

    inner class ItemHolder : RecyclerView.ViewHolder, View.OnClickListener {
        internal var name: TextView? = null
        internal var albumCount: TextView? = null
        internal var songCount: TextView? = null
        internal var artistImage: ImageView? = null
        internal var popupMenu: ImageView? = null
        internal var footer: View? = null

        constructor(v: View) : super(v) {
            name = v.findViewById(R.id.text_item_title)
            albumCount = v.findViewById(R.id.text_item_subtitle)
            songCount = v.findViewById(R.id.text_item_subtitle_2)
            artistImage = v.findViewById(R.id.image)
            popupMenu = v.findViewById(R.id.popup_menu)
            //footer = v.findViewById(R.id.footer)
        }


        override fun onClick(v: View?) {


        }
    }
}