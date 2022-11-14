package com.qiaodan.myplugin.receiver

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log

/**
 * author: created by song on 2022/11/14 18:10
 * description: TODO
 */
class MyReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {

        when (intent?.action) {
            //电源接通
            Intent.ACTION_POWER_CONNECTED -> {
                Log.d("PluginTag", "Plugin:Receiver ACTION_POWER_CONNECTED 电源连接")
            }
            //电源断开
            Intent.ACTION_POWER_DISCONNECTED -> {
                Log.d("PluginTag", "Plugin:Receiver ACTION_POWER_DISCONNECTED 电源断开")
            }
            //电池电量变化
            Intent.ACTION_BATTERY_CHANGED -> {
                val power = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
                val temp = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 32)
                Log.d("PluginTag", "Plugin:Receiver ACTION_BATTERY_CHANGED 电量:${power} 温度：${temp/10}℃ ")
            }

            BluetoothAdapter.ACTION_STATE_CHANGED -> {
                val blueState = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, 0)
                when (blueState) {
                    BluetoothAdapter.STATE_TURNING_ON -> {
                        Log.d("PluginTag", "Plugin:BlueToothReceiver-蓝牙正在打开")
                    }
                    BluetoothAdapter.STATE_ON -> {
                        Log.d("PluginTag", "Plugin:BlueToothReceiver-蓝牙已经打开")
                    }
                    BluetoothAdapter.STATE_TURNING_OFF -> {
                        Log.d("PluginTag", "Plugin:BlueToothReceiver-蓝牙正在关闭")
                    }
                    BluetoothAdapter.STATE_OFF -> {
                        Log.d("PluginTag", "Plugin:BlueToothReceiver-蓝牙已经关闭")
                    }
                }
            }

            BluetoothDevice.ACTION_ACL_CONNECTED -> {
                Log.d("PluginTag", "Plugin: Receiver  Bluetooth 蓝牙设备已连接")

            }
            BluetoothDevice.ACTION_ACL_DISCONNECTED -> {
                Log.d("PluginTag", "Plugin: Receiver  Bluetooth 蓝牙设备已断开")
                //Toast.makeText(context, "蓝牙设备已断开", Toast.LENGTH_SHORT).show()
            }
        }


    }


}