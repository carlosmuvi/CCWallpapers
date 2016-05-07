package com.carlosmuvi.ccwallpapers.view.presenter

import com.carlosmuvi.ccwallpapers.data.WallpaperRepository
import com.carlosmuvi.ccwallpapers.domain.WallPaperViewModel
import com.carlosmuvi.ccwallpapers.utils.DelegatesExt
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby.mvp.MvpView

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

interface HomeView : MvpView {
    fun showWallpapers(mockList: List<WallPaperViewModel>)

    fun showWallpaperOptionsMenu()
    fun hideWallpaperOptionsMenu()
}
