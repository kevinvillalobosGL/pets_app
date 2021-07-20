package com.kev.gl.app.petsapp.utils.extensions

import android.widget.Button
import androidx.core.view.postDelayed

/**
 * @author Kevin Villalobos
 */
/**
 * Sets a OnClickListener to the Button and blocks the Button During the Delay time
 */
fun Button.singleClick(delayInMillis: Long = 1000, block: () -> Unit) {
    this.setOnClickListener {
        this.isEnabled = false
        block()
        // Wait
        this.postDelayed(delayInMillis) {
            this.isEnabled = true
        }
    }
}