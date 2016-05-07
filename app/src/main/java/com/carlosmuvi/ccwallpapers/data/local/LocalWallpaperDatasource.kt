package com.carlosmuvi.ccwallpapers.data.local

import android.content.Context
import com.carlosmuvi.ccwallpapers.App
import com.carlosmuvi.ccwallpapers.domain.WallPaperViewModel
import com.github.salomonbrys.kotson.byString
import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import com.google.gson.JsonObject
import java.nio.charset.Charset

/**
 * Created by carlosmuvi on 6/5/16.
 */
class LocalWallpaperDatasource(val context: Context = App.instance, val mapper: Mapper = Mapper()) {

    fun list(page: Int): List<WallPaperViewModel> {
        val jsonString = loadStringFromAssets()
        val json = Gson().fromJson<List<WallpaperResponse>>(jsonString)
        return mapper.convertToDomain(json)
    }

    fun loadStringFromAssets(): String {
        val inputStream = context.assets.open("wallpapers.json")
        val buffer: ByteArray = ByteArray(inputStream.available())
        inputStream.read(buffer);
        inputStream.close();
        return String(buffer, Charset.forName("UTF-8"));
    }
}

class WallpaperResponse(val obj: JsonObject) {
    val url: String by obj.byString
    val author: String by obj.byString
}

class Mapper() {

    fun convertToDomain(source: List<WallpaperResponse>): List<WallPaperViewModel> = source.map {
        WallPaperViewModel(it.author, it.url)
    }

}
