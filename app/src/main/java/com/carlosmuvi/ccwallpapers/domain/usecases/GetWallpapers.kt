package com.carlosmuvi.ccwallpapers.domain.usecases

import com.carlosmuvi.ccwallpapers.data.WallpaperRepository
import com.carlosmuvi.ccwallpapers.domain.UseCase
import com.carlosmuvi.ccwallpapers.domain.WallPaperViewModel
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

class GetWallpapers : UseCase<Int, List<WallPaperViewModel>> {

    override fun execute(t: Int,
        onSuccess: (List<WallPaperViewModel>) -> Unit,
        onError: (Exception) -> Unit) {

        async() {
            val wallpaperRepo = WallpaperRepository()
            val a = wallpaperRepo.list(1)
            uiThread { onSuccess(a) }
        }
    }

}