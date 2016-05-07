package com.carlosmuvi.ccwallpapers.data.local

import android.content.Context
import com.carlosmuvi.ccwallpapers.App
import com.carlosmuvi.ccwallpapers.domain.WallPaperViewModel
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.nio.charset.Charset

/**
 * Created by carlosmuvi on 6/5/16.
 */
class LocalWallpaperDatasource(val context: Context = App.instance) {

    fun list(page: Int): List<WallPaperViewModel> {
        val jsonString = loadStringFromAssets()
        val wallpaperListType = object : TypeToken<List<WallpaperResponse>>() {}.type
        val wallpapers = Gson().fromJson<List<WallpaperResponse>>(jsonString, wallpaperListType)

        return convertToDomain(wallpapers)
    }

    fun loadStringFromAssets(): String {
        val inputStream = context.assets.open("backgrounds.json")
        val buffer: ByteArray = ByteArray(inputStream.available())
        inputStream.read(buffer);
        inputStream.close();
        return String(buffer, Charset.forName("UTF-8"));
    }

    fun convertToDomain(source: List<WallpaperResponse>): List<WallPaperViewModel> = source.map {
        WallPaperViewModel(it.author ?: "unknown", it.url ?: "unknown")
    }
}

class WallpaperResponse(val obj: JsonObject) {
    @SerializedName("url") val url: String? = null
    @SerializedName("author") val author: String? = null
}
