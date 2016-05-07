package com.carlosmuvi.ccwallpapers.data

import com.carlosmuvi.ccwallpapers.data.local.LocalWallpaperDatasource
import com.carlosmuvi.ccwallpapers.domain.WallPaperViewModel

/**
 * Created by carlosmuvi on 6/5/16.
 */

class WallpaperRepository(val datasource: LocalWallpaperDatasource = LocalWallpaperDatasource()) {

    val PAGE_SIZE = 20

    fun list(page: Int): List<WallPaperViewModel> {
        return datasource.list(page);
    }
}

