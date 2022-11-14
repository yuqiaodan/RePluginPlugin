package com.qiaodan.myplugin

import android.app.Application
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import com.qiaodan.myplugin.receiver.MyReceiver
import kotlin.math.log

/**
 * author: created by song on 2022/11/14 17:26
 * description: TODO
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("PluginTag", "Plugin: Application onCreate!")
        registerAllReceiver()
    }


    //注册所有接收器
    fun registerAllReceiver() {
        Log.d("PluginTag", "Plugin: 注册所有广播")

        val receiver=MyReceiver()
        val intentFilter = IntentFilter()

        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED)
        intentFilter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED)
        intentFilter.addAction(BluetoothDevice.ACTION_ACL_CONNECTED)

        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED)
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)

        registerReceiver(receiver, intentFilter)



    }

}