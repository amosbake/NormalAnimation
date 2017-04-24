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

public class PulseAnimator extends BaseAnimator {
  @Override protected void prepare(final View target) {
    Keyframe keyframe1 = Keyframe.ofFloat(0, 1f);
    Keyframe keyframe2 = Keyframe.ofFloat(0.5f, 1.05f);
    Keyframe keyframe3 = Keyframe.ofFloat(1, 1f);

    PropertyValuesHolder valuesHolder =
        PropertyValuesHolder.ofKeyframe("scale", keyframe1, keyframe2, keyframe3);
    ValueAnimator pluse = ValueAnimator.ofPropertyValuesHolder(valuesHolder);
    pluse.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        target.setScaleX((Float) animation.getAnimatedValue("scale"));
        target.setScaleY((Float) animation.getAnimatedValue("scale"));
      }
    });
    getAnimator().play(pluse);
  }
}
