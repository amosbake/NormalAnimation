package mopel.io.lib_kotlin

import android.animation.Animator
import android.animation.AnimatorSet
import android.support.v4.view.ViewCompat
import android.view.View
import android.view.animation.Interpolator

/**
 * Author: mopel
 * Date : 2017/4/23
 */

abstract class BaseAnimator {

    var animator: AnimatorSet = AnimatorSet()
        private set
    private var duration = DEFAULT_DURATION

    protected abstract fun prepare(target: View)

    fun animate() {
        start()
    }

    fun restart() {
        animator = animator.clone()

    }

    fun start() {
        animator.duration = duration
        animator.start()
    }

    fun setTarget(target: View): BaseAnimator {
        reset(target)
        prepare(target)
        return this
    }

    fun reset(target: View) {
        ViewCompat.setAlpha(target, 1f)
        ViewCompat.setScaleX(target, 1f)
        ViewCompat.setScaleY(target, 1f)
        ViewCompat.setTranslationX(target, 1f)
        ViewCompat.setTranslationY(target, 1f)
        ViewCompat.setTranslationZ(target, 1f)
        ViewCompat.setRotation(target, 1f)
        ViewCompat.setRotationX(target, 1f)
        ViewCompat.setRotationY(target, 1f)
    }

    fun cancel() {
        animator.cancel()
    }

    val isRunning: Boolean
        get() = animator.isRunning

    val isStarted: Boolean
        get() = animator.isStarted

    fun setStartDelay(delay: Long): BaseAnimator {
        animator.startDelay = delay
        return this
    }

    fun addAnimatorListener(listener: Animator.AnimatorListener): BaseAnimator {
        animator.addListener(listener)
        return this
    }

    fun setInterpolator(interpolator: Interpolator): BaseAnimator {
        animator.interpolator = interpolator
        return this
    }

    fun removeAnimatorListener(l: Animator.AnimatorListener) {
        animator.removeListener(l)
    }

    fun removeAllListener() {
        animator.removeAllListeners()
    }

    fun getDuration(): Long {
        return duration
    }

    fun setDuration(duration: Long): BaseAnimator {
        this.duration = duration
        return this
    }

    companion object {
        private val DEFAULT_DURATION: Long = 1000
    }
}
