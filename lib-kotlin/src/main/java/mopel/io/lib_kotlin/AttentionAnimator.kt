package mopel.io.lib_kotlin

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.graphics.Path
import android.view.View
import android.view.animation.Interpolator

/**
 * Author: mopel
 * Date : 2017/4/23
 * cssAnimation: link https://github.com/daneden/animate.css/blob/master/source/attention_seekers

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

class ShakeAnimator : BaseAnimator() {
    override fun prepare(target: View) {
        animator.play(
                ObjectAnimator.ofFloat(target, "translationX", 0f, -10f, 10f, -10f, 10f, -10f, 10f, -10f, 10f, 0f)
        )
    }
}

class BounceAnimator : BaseAnimator() {
    override fun prepare(target: View) {
        val kf0 = Keyframe.ofFloat(0f, 0f)
        val kf1 = {
            val kf = Keyframe.ofFloat(0.2f, 0f)
            kf.interpolator = interpolator_at_20_53_80()
            kf
        }.invoke()
        val kf2 = {
            val kf = Keyframe.ofFloat(0.40f, -30f)
            kf.interpolator = interpolator_at_40_43_70()
            kf
        }.invoke()
        val kf3 = {
            val kf = Keyframe.ofFloat(0.43f, -30f)
            kf.interpolator = interpolator_at_40_43_70()
            kf
        }.invoke()
        val kf4 = {
            val kf = Keyframe.ofFloat(0.53f, 0f)
            kf.interpolator = interpolator_at_20_53_80()
            kf
        }.invoke()
        val kf5 = {
            val kf = Keyframe.ofFloat(0.7f, -15f)
            kf.interpolator = interpolator_at_40_43_70()
            kf
        }.invoke()
        val kf6 = {
            val kf = Keyframe.ofFloat(0.8f, 0f)
            kf.interpolator = interpolator_at_20_53_80()
            kf
        }.invoke()
        val kf7 = Keyframe.ofFloat(0.9f, -4f)
        val kf8 = Keyframe.ofFloat(1f, 0f)
        val translationYHolder = PropertyValuesHolder.ofKeyframe("translationY", kf0, kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8)
        val valueAnimator = ValueAnimator.ofPropertyValuesHolder(translationYHolder)
        valueAnimator.addUpdateListener {
            target.translationY = it?.getAnimatedValue("translationY") as Float
        }
        animator.play(valueAnimator)
    }

    fun interpolator_at_20_53_80(): Interpolator = CubicBezierInterpolator(0.215, 0.610, 0.355, 1.000)
    fun interpolator_at_40_43_70(): Interpolator = CubicBezierInterpolator(0.755, 0.050, 0.855, 0.060)
}

class FlashAnimator : BaseAnimator() {
    override fun prepare(target: View) {
        animator.play(
                ObjectAnimator.ofFloat(target, "opacity", 1f, 0f, 1f, -0f, 1f)
        )
    }
}


