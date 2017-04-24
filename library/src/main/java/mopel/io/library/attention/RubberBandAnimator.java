package mopel.io.library.attention;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/4/24
 */

public class RubberBandAnimator extends BaseAnimator {
  @Override protected void prepare(final View target) {
    Keyframe[] scaleX = new Keyframe[7];
    scaleX[0] = Keyframe.ofFloat(0f, 1);
    scaleX[1] = Keyframe.ofFloat(0.3f, 1.25f);
    scaleX[2] = Keyframe.ofFloat(0.4f, .75f);
    scaleX[3] = Keyframe.ofFloat(0.5f, 1.15f);
    scaleX[4] = Keyframe.ofFloat(0.65f, .95f);
    scaleX[5] = Keyframe.ofFloat(0.75f, 1.05f);
    scaleX[6] = Keyframe.ofFloat(1f, 1f);

    PropertyValuesHolder scaleXHolder = PropertyValuesHolder.ofKeyframe("scaleX", scaleX);

    Keyframe[] scaleY = new Keyframe[7];
    scaleY[0] = Keyframe.ofFloat(0f, 1);
    scaleY[1] = Keyframe.ofFloat(0.3f, .75f);
    scaleY[2] = Keyframe.ofFloat(0.4f, 1.25f);
    scaleY[3] = Keyframe.ofFloat(0.5f, .85f);
    scaleY[4] = Keyframe.ofFloat(0.65f, 1.05f);
    scaleY[5] = Keyframe.ofFloat(0.75f, .95f);
    scaleY[6] = Keyframe.ofFloat(1f, 1f);

    PropertyValuesHolder scaleYHolder = PropertyValuesHolder.ofKeyframe("scaleY", scaleY);

    ValueAnimator valueAnimator = ValueAnimator.ofPropertyValuesHolder(scaleXHolder, scaleYHolder);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        target.setScaleX((Float) animation.getAnimatedValue("scaleX"));
        target.setScaleY((Float) animation.getAnimatedValue("scaleY"));
      }
    });
    getAnimator().play(valueAnimator);
  }
}
