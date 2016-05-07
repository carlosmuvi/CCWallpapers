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
        with(home_recyclerview) {
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun fakeWallpaperList(): List<WallPaperViewModel> {

        var list: List<WallPaperViewModel> = emptyList()
        for (i in 1..100) {
            list += WallPaperViewModel("Viaje $i",
                "http://media2.newsnet5.com/photo/2014/03/10/" +
                    "chuck%20norris_crop_1394454213136_3349583_ver1.0_640_480.jpg")
        }
        return list
    }

    override fun createPresenter(): HomePresenter {
        return HomePresenter()
    }

    override fun showWallpapers(mockList: List<WallPaperViewModel>) {
        home_recyclerview.adapter = WallpaperListAdapter(fakeWallpaperList(), { alert(it.title) })
    }

}

