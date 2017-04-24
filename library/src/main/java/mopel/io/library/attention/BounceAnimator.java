package mopel.io.library.attention;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/4/23
 */

public class BounceAnimator extends BaseAnimator {

  @Override protected void prepare(final View target) {
    Keyframe kf_0 = Keyframe.ofFloat(0f, 0f);
    Keyframe kf_1 = Keyframe.ofFloat(0.2f, 0f);
    Keyframe kf_2 = Keyframe.ofFloat(0.40f, -30f);
    Keyframe kf_3 = Keyframe.ofFloat(0.43f, -30f);
    Keyframe kf_4 = Keyframe.ofFloat(0.53f, 0f);
    Keyframe kf_5 = Keyframe.ofFloat(0.7f, -15f);
    Keyframe kf_6 = Keyframe.ofFloat(0.8f, 0f);
    Keyframe kf_7 = Keyframe.ofFloat(0.9f, -4f);
    Keyframe kf_8 = Keyframe.ofFloat(1f, 0f);
    PropertyValuesHolder transitionY =
        PropertyValuesHolder.ofKeyframe("translationY", kf_0, kf_1, kf_2, kf_3, kf_4, kf_5, kf_6,
            kf_7, kf_8);
    ValueAnimator valueAnimator = ValueAnimator.ofPropertyValuesHolder(transitionY);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        target.setTranslationY((Float) animation.getAnimatedValue("translationY"));
      }
    });
    getAnimator().play(valueAnimator);
  }
}
