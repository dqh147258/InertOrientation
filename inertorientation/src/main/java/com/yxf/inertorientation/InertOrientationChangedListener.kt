package com.yxf.inertorientation

import android.content.Context
import android.view.OrientationEventListener

open class InertOrientationChangedListener(
    private val context: Context,
    private val offsetAngle: Int = DEFAULT_OFFSET_ANGLE,
    private val callback: (Int) -> Unit
) {

    companion object {

        const val DEFAULT_OFFSET_ANGLE = 30

        const val INVALID_ORIENTATION = -1
    }

    private var orientation: Int = INVALID_ORIENTATION

    val currentOrientation: Int
        get() {
            return orientation
        }

    private val eventListener by lazy {
        object : OrientationEventListener(context) {
            override fun onOrientationChanged(angle: Int) {
                setOrientationIfChanged(angle)
            }
        }
    }

    fun enable() {
        eventListener.enable()
    }

    fun disable() {
        eventListener.disable()
    }


    private fun setOrientationIfChanged(angle: Int) {
        if (orientation == INVALID_ORIENTATION) {
            adjustOrientation(angle)
        }
        val currentAngle = orientation * 90
        val abs = Math.abs((currentAngle - angle + 360) % 360)
        if ((abs > 45 + offsetAngle && abs <= 180) || (abs < 315 - offsetAngle && abs >= 180)) {
            adjustOrientation(angle)
        }
    }

    private fun adjustOrientation(angle: Int) {
        val orientation = ((angle + 45) / 90) % 4
        setOrientation(orientation)
    }

    private fun setOrientation(orientation: Int) {
        if (this.orientation == orientation) {
            return
        }
        this.orientation = orientation
        callback.invoke(orientation)
    }

}