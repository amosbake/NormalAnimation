package mopel.io.lib_kotlin

import android.animation.ObjectAnimator
import android.view.View

/**
 * Author: mopel
 * Date : 2017/4/23
 * cssAnimation: link https://github.com/daneden/animate.css/blob/master/source/attention_seekers/tada.css

 */

class TadaAnimator : BaseAnimator() {
    override fun prepare(target: View) {
        animator.playTogether(
                ObjectAnimator.ofFloat(target, "scaleX", 1f, 0.9f, 0.9f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1f),
                ObjectAnimator.ofFloat(target, "scaleY", 1f, 0.9f, 0.9f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1f),
                ObjectAnimator.ofFloat(target, "rotation", 0f, -3f, -3f, 3f, -3f, 3f, -3f, 3f, -3f, 0f)
        )
    }
}
