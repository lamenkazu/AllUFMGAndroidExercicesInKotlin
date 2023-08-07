package com.daedrii.allufmgandroidexercicesinkotlin.e05.broadcast_receivers

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daedrii.allufmgandroidexercicesinkotlin.R

class BroadcastReceiversActivity : AppCompatActivity() {

    private val batteryReceiver = BatteryReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receivers)

        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(batteryReceiver, intentFilter)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(batteryReceiver)
    }
}