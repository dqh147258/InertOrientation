package com.yxf.orientationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Surface
import com.yxf.inertorientation.SmartInertOrientationListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SmartInertOrientationListener(this) {
            Log.d("Debug", "current orientation: $it")
        }
    }
}