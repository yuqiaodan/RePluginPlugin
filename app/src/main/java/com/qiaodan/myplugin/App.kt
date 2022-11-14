package com.qiaodan.myplugin

import android.app.Application
import android.util.Log
import kotlin.math.log

/**
 * author: created by song on 2022/11/14 17:26
 * description: TODO
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("PluginTag", "Plugin: Application onCreate!")
    }
}