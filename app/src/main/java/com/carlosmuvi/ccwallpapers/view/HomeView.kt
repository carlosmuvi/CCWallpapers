package com.carlosmuvi.ccwallpapers.view

import com.carlosmuvi.ccwallpapers.domain.WallPaperViewModel
import com.hannesdorfmann.mosby.mvp.MvpView

/**
 * Created by carlosmuvi on 3/5/16.
 */
interface HomeView : MvpView {
    fun showWallpapers(mockList: List<WallPaperViewModel>)
}

