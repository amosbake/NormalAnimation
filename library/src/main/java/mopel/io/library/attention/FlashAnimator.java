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

public class FlashAnimator extends BaseAnimator {
  @Override protected void prepare(final View target) {
    Keyframe kf_0 = Keyframe.ofFloat(0f, 1f);
    Keyframe kf_1 = Keyframe.ofFloat(0.25f, 0f);
    Keyframe kf_2 = Keyframe.ofFloat(0.50f, 1f);
    Keyframe kf_3 = Keyframe.ofFloat(0.75f, -0f);
    Keyframe kf_4 = Keyframe.ofFloat(1f, 1f);

    PropertyValuesHolder opacity =
        PropertyValuesHolder.ofKeyframe("opacity", kf_0, kf_1, kf_2, kf_3, kf_4);
    ValueAnimator valueAnimator = ValueAnimator.ofPropertyValuesHolder(opacity);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        target.setAlpha((Float) animation.getAnimatedValue("opacity"));
      }
    });
    getAnimator().play(valueAnimator);
  }
}
