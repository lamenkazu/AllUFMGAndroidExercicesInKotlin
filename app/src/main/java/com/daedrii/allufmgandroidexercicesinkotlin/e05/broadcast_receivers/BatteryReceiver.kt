package com.daedrii.allufmgandroidexercicesinkotlin.e05.broadcast_receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate

class BatteryReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == Intent.ACTION_BATTERY_CHANGED){
            val battery = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)


            if(battery <= 20)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        }
    }
}