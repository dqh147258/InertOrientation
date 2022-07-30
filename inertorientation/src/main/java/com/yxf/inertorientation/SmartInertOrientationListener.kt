package com.yxf.inertorientation

import android.content.Context
import androidx.core.app.ComponentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class SmartInertOrientationListener(
    private val context: Context,
    lifecycleOwner: LifecycleOwner,
    private val offsetAngle: Int = 30,
    private val callback: (Int) -> Unit
) : InertOrientationChangedListener(context, offsetAngle, callback) {

    private val enableListener by lazy {
        enable()
    }

    constructor(activity: ComponentActivity, offsetAngle: Int = 30, callback: (Int) -> Unit) : this(
        activity,
        activity,
        offsetAngle,
        callback
    )

    init {
        val lifecycle = lifecycleOwner.lifecycle
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED)) {
            initListener()
        }
        lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                when (event) {
                    Lifecycle.Event.ON_CREATE -> {
                        initListener()
                    }
                    Lifecycle.Event.ON_DESTROY -> {
                        disable()
                    }
                }
            }

        })

    }

    private fun initListener() {
        enableListener
    }


}