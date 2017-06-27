package mopel.io.library.attention;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import mopel.io.library.BaseAnimator;
import mopel.io.library.CubicBezierInterpolator;

/**
 * Author: mopel
 * Date : 2017/4/23
 * cssAnimation: link https://github.com/daneden/animate.css/blob/master/source/attention_seekers/bounce.css
 */

public class BounceAnimator extends BaseAnimator {

  @Override protected void prepare(final View target) {
    Keyframe kf_0 = Keyframe.ofFloat(0f, 0f);
    Keyframe kf_1 = Keyframe.ofFloat(0.2f, 0f);
    kf_1.setInterpolator(interpolator_at_20_53_80());
    Keyframe kf_2 = Keyframe.ofFloat(0.40f, -30f);
    kf_2.setInterpolator(interpolator_at_40_43_70());
    Keyframe kf_3 = Keyframe.ofFloat(0.43f, -30f);
    kf_3.setInterpolator(interpolator_at_40_43_70());
    Keyframe kf_4 = Keyframe.ofFloat(0.53f, 0f);
    kf_4.setInterpolator(interpolator_at_20_53_80());
    Keyframe kf_5 = Keyframe.ofFloat(0.7f, -15f);
    kf_5.setInterpolator(interpolator_at_40_43_70());
    Keyframe kf_6 = Keyframe.ofFloat(0.8f, 0f);
    kf_6.setInterpolator(interpolator_at_20_53_80());
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

  private Interpolator interpolator_at_20_53_80() {
    return new CubicBezierInterpolator(0.215, 0.610, 0.355, 1.000);
  }

  private Interpolator interpolator_at_40_43_70() {
    return new CubicBezierInterpolator(0.755, 0.050, 0.855, 0.060);
  }
}
