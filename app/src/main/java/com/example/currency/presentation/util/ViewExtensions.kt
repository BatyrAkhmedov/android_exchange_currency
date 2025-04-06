package com.example.currency.presentation.util

import android.view.View
import androidx.core.view.isVisible

fun View.animateVisibility(show: Boolean, duration: Long = 300) {
    if (show) {
        if (!isVisible) {
            alpha = 0f
            scaleX = 0.8f
            scaleY = 0.8f
            isVisible = true
            animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(duration)
                .start()
        }
    } else {
        if (isVisible) {
            animate()
                .alpha(0f)
                .scaleX(0.8f)
                .scaleY(0.8f)
                .setDuration(duration)
                .withEndAction { isVisible = false }
                .start()
        }
    }
}