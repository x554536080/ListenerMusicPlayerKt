package com.kuma.listenermusicplayerkt.ui.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ArtistAdapter(context: Activity, action: String) :
    RecyclerView.Adapter<ArtistAdapter.ItemHolder>() {
//什么时候不用管构造函数的？


    private fun injectDependencies(context: Activity) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        override fun onClick(v: View?) {


        }
    }
}