package com.carlosmuvi.ccwallpapers.view

import com.carlosmuvi.ccwallpapers.domain.WallPaperViewModel
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter

/**
 * Created by carlosmuvi on 3/5/16.
 */
class HomePresenter : MvpBasePresenter<HomeView>() {

    fun loadWallpapers() {

        val mockList = mutableListOf<WallPaperViewModel>();

        for (i in 1..100) {
            mockList += WallPaperViewModel("Wallpaper $i", "http://vignette2.wikia.nocookie" +
                ".net/uncyclopedia/images/d/dc/Chuck-norris-002.jpg/revision/latest?cb=20080312162141");
        }

        view?.showWallpapers(mockList)
    }
}