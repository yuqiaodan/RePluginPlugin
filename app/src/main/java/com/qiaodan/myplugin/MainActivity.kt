package com.qiaodan.myplugin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qihoo360.replugin.RePlugin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //RePlugin.getHostClassLoader()
    }
}