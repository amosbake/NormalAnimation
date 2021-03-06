package mopel.io.library.bounce.in;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import mopel.io.library.BaseAnimator;
import mopel.io.library.CubicBezierInterpolator;

/**
 * Author: mopel
 * Date : 2017/5/3
 * https://github.com/daneden/animate.css/blob/master/source/bouncing_entrances/bounceIn.css
 */

public class BounceInAnimator extends BaseAnimator {
  private Interpolator interpolator = new CubicBezierInterpolator(0.215, 0.610, 0.355, 1.000);

  @Override protected void prepare(final View target) {
    Keyframe kf_scale_1 = Keyframe.ofFloat(0, .3f);
    kf_scale_1.setInterpolator(interpolator);
    Keyframe kf_scale_2 = Keyframe.ofFloat(.2f, 1.1f);
    kf_scale_2.setInterpolator(interpolator);
    Keyframe kf_scale_3 = Keyframe.ofFloat(.4f, .9f);
    kf_scale_3.setInterpolator(interpolator);
    Keyframe kf_scale_4 = Keyframe.ofFloat(.6f, 1.03f);
    kf_scale_4.setInterpolator(interpolator);
    Keyframe kf_scale_5 = Keyframe.ofFloat(.8f, .97f);
    kf_scale_5.setInterpolator(interpolator);
    Keyframe kf_scale_6 = Keyframe.ofFloat(1, .1f);

    PropertyValuesHolder scaleHolder =
        PropertyValuesHolder.ofKeyframe("scale", kf_scale_1, kf_scale_2, kf_scale_3, kf_scale_4,
            kf_scale_5, kf_scale_6);

    Keyframe kf_alpha_1 = Keyframe.ofFloat(0, 0);
    Keyframe kf_alpha_2 = Keyframe.ofFloat(.6f, 1);
    Keyframe kf_alpha_3 = Keyframe.ofFloat(1, 1);

    PropertyValuesHolder alphaHolder =
        PropertyValuesHolder.ofKeyframe("alpha", kf_alpha_1, kf_alpha_2, kf_alpha_3);

    ValueAnimator valueAnimator = ValueAnimator.ofPropertyValuesHolder(scaleHolder, alphaHolder);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        target.setScaleX((Float) animation.getAnimatedValue("scale"));
        target.setScaleY((Float) animation.getAnimatedValue("scale"));
        target.setAlpha((Float) animation.getAnimatedValue("alpha"));
      }
    });
    getAnimator().play(valueAnimator);
  }
}
