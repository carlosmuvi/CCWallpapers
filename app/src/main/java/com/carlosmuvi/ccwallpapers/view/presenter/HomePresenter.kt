package com.carlosmuvi.ccwallpapers.view.presenter

import com.carlosmuvi.ccwallpapers.domain.WallPaperViewModel
import com.carlosmuvi.ccwallpapers.domain.usecases.GetWallpapers
import com.carlosmuvi.ccwallpapers.domain.usecases.SetAsWallpaper
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby.mvp.MvpView

/**
 * Created by carlosmuvi on 3/5/16.
 */
class HomePresenter : MvpBasePresenter<HomeView>() {

    val setAsWallpaper by lazy { SetAsWallpaper() }
    val getWallpapers by lazy { GetWallpapers() }

    fun loadWallpapers() {
        getWallpapers.execute(1, {
            view?.showWallpapers(it)
        }, {
            view?.showMessage("Error loading wallpapers!")
        })
    }

    fun onWallpaperOptionsClick(selectedWallpaper: WallPaperViewModel) {
        view?.showWallpaperOptionsMenu(selectedWallpaper)
    }

    fun onSetAsWallpaperClick(wallPaperViewModel: WallPaperViewModel) {
        setAsWallpaper.execute(wallPaperViewModel, {
            view?.showMessage("Wallpaper set!")
        }, {
            view?.showMessage("Error setting wallpaper!")
        })
    }

}

interface HomeView : MvpView {
    fun showWallpapers(mockList: List<WallPaperViewModel>)

    fun showWallpaperOptionsMenu(selectedWallpaper: WallPaperViewModel)
    fun hideWallpaperOptionsMenu()
    fun showMessage(message: String)
}
