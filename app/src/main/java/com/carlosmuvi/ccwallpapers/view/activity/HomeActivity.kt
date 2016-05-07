package com.carlosmuvi.ccwallpapers.view.activity

import alert
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.carlosmuvi.ccwallpapers.R
import com.carlosmuvi.ccwallpapers.domain.WallPaperViewModel
import com.carlosmuvi.ccwallpapers.view.HomePresenter
import com.carlosmuvi.ccwallpapers.view.HomeView
import com.carlosmuvi.ccwallpapers.view.adapter.WallpaperListAdapter
import com.hannesdorfmann.mosby.mvp.MvpActivity
import kotlinx.android.synthetic.main.layout_home_content.*


class HomeActivity : MvpActivity<HomeView, HomePresenter>(), HomeView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initRecycler();
        presenter.loadWallpapers()
    }

    private fun initRecycler() {
            home_recyclerview.layoutManager = LinearLayoutManager(this)
    }

    override fun createPresenter(): HomePresenter {
        return HomePresenter()
    }

    override fun showWallpapers(mockList: List<WallPaperViewModel>) {
        home_recyclerview.adapter = WallpaperListAdapter(mockList, { alert(it.title) })
    }

}

