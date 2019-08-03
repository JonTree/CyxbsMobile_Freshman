package com.mredrock.cyxbs.freshman.util

import android.animation.ObjectAnimator
import android.content.Context
import android.widget.ImageView

class MyImageView(context:Context):ImageView(context) {
    init {
        val animator = ObjectAnimator.ofFloat()
    }
}