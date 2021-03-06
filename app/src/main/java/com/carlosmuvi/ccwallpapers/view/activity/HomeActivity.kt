package com.carlosmuvi.ccwallpapers.view.activity

import alert
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.carlosmuvi.ccwallpapers.R
import com.carlosmuvi.ccwallpapers.domain.WallPaperViewModel
import com.carlosmuvi.ccwallpapers.utils.DelegatesExt
import com.carlosmuvi.ccwallpapers.view.adapter.WallpaperListAdapter
import com.carlosmuvi.ccwallpapers.view.presenter.HomePresenter
import com.carlosmuvi.ccwallpapers.view.presenter.HomeView
import com.hannesdorfmann.mosby.mvp.MvpActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.layout_home_content.*
import kotlinx.android.synthetic.main.layout_home_options_bottom_menu.*
import onScroll


class HomeActivity : MvpActivity<HomeView, HomePresenter>(), HomeView {

    var bottomSheetBehaviour by DelegatesExt.notNullSingleValue<BottomSheetBehavior<LinearLayout>>()
    var currentSelectedWallpaper: WallPaperViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initToolbar();
        initRecycler();
        initBottomSheetMenu();

        presenter.loadWallpapers()
    }

    private fun initToolbar() {
        appbar.title = "CCWallpapers"
    }

    private fun initBottomSheetMenu() {
        bottomSheetBehaviour = BottomSheetBehavior.from(layout_home_options_bottom_menu_container);
        bottomSheetBehaviour.state = BottomSheetBehavior.STATE_HIDDEN

        layout_home_options_bottom_menu_text_setaswpp.setOnClickListener {
            presenter.onSetAsWallpaperClick(currentSelectedWallpaper!!)
        }
    }

    private fun initRecycler() {
        home_recyclerview.layoutManager = LinearLayoutManager(this)
        home_recyclerview.onScroll {
            hideWallpaperOptionsMenu()
        }
    }

    override fun createPresenter(): HomePresenter {
        return HomePresenter()
    }

    override fun showWallpapers(mockList: List<WallPaperViewModel>) {
        home_recyclerview.adapter = WallpaperListAdapter(mockList, { presenter.onWallpaperOptionsClick(it) })
    }

    override fun showWallpaperOptionsMenu(selectedWallpaper: WallPaperViewModel) {
        currentSelectedWallpaper = selectedWallpaper
        bottomSheetBehaviour.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun hideWallpaperOptionsMenu() {
        if (bottomSheetBehaviour.state != BottomSheetBehavior.STATE_HIDDEN) {
            bottomSheetBehaviour.state = BottomSheetBehavior.STATE_HIDDEN
        }
    }

    override fun showMessage(message: String) {
        alert(message)
    }

    override fun onBackPressed() {
        if (bottomSheetBehaviour.state == BottomSheetBehavior.STATE_EXPANDED) {
            hideWallpaperOptionsMenu()
        } else {
            super.onBackPressed()
        }
    }

}

