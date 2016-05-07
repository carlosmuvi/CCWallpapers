package com.carlosmuvi.ccwallpapers.data

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.carlosmuvi.ccwallpapers.App
import android.app.WallpaperManager as NativeWallpaperManager

/**
 * Created by carlosmuvi on 07/05/16.
 */

class WallpaperManager(val context: Context = App.instance) {

    fun setAsWallpaper(wallPaperViewModel: String) {
        val nativeWallpaperManager = NativeWallpaperManager.getInstance(context);

        val bitmap = Glide.with(context)
            .load(wallPaperViewModel)
            .asBitmap()
            .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
            .get()


        nativeWallpaperManager.setBitmap(bitmap)

    }
}

