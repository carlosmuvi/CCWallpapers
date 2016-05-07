package com.carlosmuvi.ccwallpapers.domain.usecases

import com.carlosmuvi.ccwallpapers.data.WallpaperManager
import com.carlosmuvi.ccwallpapers.domain.UseCase
import com.carlosmuvi.ccwallpapers.domain.WallPaperViewModel
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

/**
 * Created by carlosmuvi on 07/05/16.
 */

class SetAsWallpaper : UseCase<WallPaperViewModel, Unit> {

    override fun execute(t: WallPaperViewModel, onSuccess: (Unit) -> Unit, onError: (Exception) -> Unit) {

        async() {
            try {
                val wallpaperManager = WallpaperManager()
                wallpaperManager.setAsWallpaper(t.pictureUrl)
                uiThread { onSuccess(Unit) }
            } catch(e: Exception) {
                uiThread { onError(e) }
            }
        }
    }

}

