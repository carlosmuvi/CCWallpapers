package com.carlosmuvi.ccwallpapers

import android.app.Application
import com.carlosmuvi.ccwallpapers.utils.DelegatesExt

/**
 * Created by carlosmuvi on 3/5/16.
 */
class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}