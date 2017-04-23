package mopel.io.library;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Interpolator;

/**
 * Author: mopel
 * Date : 2017/4/23
 */

public abstract class BaseAnimator {
  private static final long DEFAULT_DURATION = 1000;

  private AnimatorSet animatorSet;
  private long duration = DEFAULT_DURATION;

  {
    animatorSet = new AnimatorSet();
  }

  protected abstract void prepare(View target);

  public void animate(){
    start();
  }

  public void restart(){
    animatorSet = animatorSet.clone();

  }

  public void start(){
    animatorSet.setDuration(duration);
    animatorSet.start();
  }

  public BaseAnimator setTarget(View target){
    reset(target);
    prepare(target);
    return this;
  }

  public void reset(View target){
    ViewCompat.setAlpha(target,1);
    ViewCompat.setScaleX(target,1);
    ViewCompat.setScaleY(target,1);
    ViewCompat.setTranslationX(target,1);
    ViewCompat.setTranslationY(target,1);
    ViewCompat.setTranslationZ(target,1);
    ViewCompat.setRotation(target,1);
    ViewCompat.setRotationX(target,1);
    ViewCompat.setRotationY(target,1);
  }

  public void cancel() {
    animatorSet.cancel();
  }

  public boolean isRunning() {
    return animatorSet.isRunning();
  }

  public boolean isStarted() {
    return animatorSet.isStarted();
  }


  public BaseAnimator setDuration(long duration) {
    this.duration = duration;
    return this;
  }

  public BaseAnimator setStartDelay(long delay){
    animatorSet.setStartDelay(delay);
    return this;
  }

  public BaseAnimator addAnimatorListener(Animator.AnimatorListener listener){
    animatorSet.addListener(listener);
    return this;
  }

  public BaseAnimator setInterpolator(Interpolator interpolator) {
    animatorSet.setInterpolator(interpolator);
    return this;
  }


  public void removeAnimatorListener(Animator.AnimatorListener l) {
    animatorSet.removeListener(l);
  }

  public void removeAllListener() {
    animatorSet.removeAllListeners();
  }


  public long getDuration() {
    return duration;
  }


  public AnimatorSet getAnimator() {
    return animatorSet;
  }
}
