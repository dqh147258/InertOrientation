package com.yxf.orientationexample

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Surface
import com.yxf.inertorientation.SmartInertOrientationListener

class MainActivity : AppCompatActivity() {


    private val listener = SmartInertOrientationListener(this) {
        Log.d("Debug", "current orientation: $it")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        Log.d("Debug", "get orientation directly: ${listener.currentOrientation}")
    }
}