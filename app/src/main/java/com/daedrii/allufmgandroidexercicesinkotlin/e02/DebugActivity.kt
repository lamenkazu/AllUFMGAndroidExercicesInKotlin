package com.daedrii.allufmgandroidexercicesinkotlin.e02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.daedrii.allufmgandroidexercicesinkotlin.R

open class DebugActivity : AppCompatActivity() {

    private var activityName = this::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debug)

        Log.i("DebugActivity", "$activityName Activity Created")
    }

    override fun onStart() {
        super.onStart()
        Log.i("DebugActivity", "$activityName Activity Started")
    }

    override fun onResume() {
        super.onResume()
        Log.i("DebugActivity", "$activityName Activity Resumed")

    }

    override fun onPause() {
        super.onPause()
        Log.i("DebugActivity", "$activityName Activity Paused")

    }

    override fun onStop() {
        super.onStop()
        Log.i("DebugActivity", "$activityName Activity Stopped")

    }

    override fun onRestart() {
        super.onRestart()
        Log.i("DebugActivity", "$activityName Activity Restarted")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("DebugActivity", "$activityName Activity Destroyed")

    }
}