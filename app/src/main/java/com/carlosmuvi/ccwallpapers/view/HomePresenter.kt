package com.carlosmuvi.ccwallpapers.view

import com.carlosmuvi.ccwallpapers.data.WallpaperRepository
import com.carlosmuvi.ccwallpapers.utils.DelegatesExt
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter

/**
 * Created by carlosmuvi on 3/5/16.
 */
class HomePresenter : MvpBasePresenter<HomeView>() {

    var wallpaperRepo by DelegatesExt.notNullSingleValue<WallpaperRepository>()

    fun loadWallpapers() {

        wallpaperRepo = WallpaperRepository()
        val a = wallpaperRepo.list(1)
        view?.showWallpapers(a)

    }

    fun onWallpaperOptionsClick() {
        view?.showWallpaperOptionsMenu()
    }
}