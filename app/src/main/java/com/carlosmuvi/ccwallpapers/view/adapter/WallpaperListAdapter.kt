package com.carlosmuvi.ccwallpapers.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.carlosmuvi.ccwallpapers.R
import com.carlosmuvi.ccwallpapers.domain.WallPaperViewModel
import kotlinx.android.synthetic.main.item_home_wallpaper.view.*


class WallpaperListAdapter(
    val wallpaperList: List<WallPaperViewModel>,
    val itemClick: (WallPaperViewModel) -> Unit) :
    RecyclerView.Adapter<WallpaperListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_home_wallpaper, parent, false)
        return ViewHolder(v, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(wallpaperList[position])
    }

    override fun getItemCount() = wallpaperList.count()

    class ViewHolder(view: View, val itemClick: (WallPaperViewModel) -> Unit) :
        RecyclerView.ViewHolder(view) {

        fun bind(wallPaperViewModel: WallPaperViewModel) {

            with(wallPaperViewModel) {
                Glide.with(itemView.context).load(pictureUrl).centerCrop().into(itemView.home_item_imageview)
                itemView.setOnClickListener { itemClick(wallPaperViewModel) }
            }
        }

    }
}
