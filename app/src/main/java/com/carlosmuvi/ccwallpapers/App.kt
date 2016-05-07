package com.carlosmuvi.ccwallpapers

import android.app.Application
import com.carlosmuvi.ccwallpapers.utils.DelegatesExt

/**
 * Created by carlosmuvi on 3/5/16.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

}