package mopel.io.library.zoom.out;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import mopel.io.library.BaseAnimator;
import mopel.io.library.CubicBezierInterpolator;

/**
 * Author: mopel
 * Date : 2017/4/25
 * cssAnimation: https://github.com/daneden/animate.css/blob/master/source/zooming_exits/zoomOutUp.css
 */

public class ZoomOutUpAnimator extends BaseAnimator {
  private Interpolator phase2 = new CubicBezierInterpolator(0.550, 0.055, 0.675, 0.190);
  private Interpolator phase1 = new CubicBezierInterpolator(0.175, 0.885, 0.320, 1);

  @Override protected void prepare(final View target) {
    Keyframe kf_scale_1 = Keyframe.ofFloat(0, 1f);
    Keyframe kf_scale_2 = Keyframe.ofFloat(.4f, .475f);
    Keyframe kf_scale_3 = Keyframe.ofFloat(1, .1f);
    kf_scale_2.setInterpolator(phase1);
    kf_scale_3.setInterpolator(phase2);
    PropertyValuesHolder scaleHolder =
        PropertyValuesHolder.ofKeyframe("scale", kf_scale_1, kf_scale_2, kf_scale_3);

    Keyframe kf_translation_1 = Keyframe.ofFloat(0, 0);
    Keyframe kf_translation_2 = Keyframe.ofFloat(.4f, 60);
    Keyframe kf_translation_3 = Keyframe.ofFloat(1, -2000);
    kf_translation_2.setInterpolator(phase1);
    kf_translation_3.setInterpolator(phase2);
    PropertyValuesHolder translateHolder =
        PropertyValuesHolder.ofKeyframe("translate", kf_translation_1, kf_translation_2,
            kf_translation_3);

    Keyframe kf_alpha_1 = Keyframe.ofFloat(0, 1f);
    Keyframe kf_alpha_2 = Keyframe.ofFloat(.4f, 0f);
    Keyframe kf_alpha_3 = Keyframe.ofFloat(1, 0f);
    kf_alpha_2.setInterpolator(phase1);
    kf_alpha_3.setInterpolator(phase2);
    PropertyValuesHolder alphaHolder =
        PropertyValuesHolder.ofKeyframe("alpha", kf_alpha_1, kf_alpha_2, kf_alpha_3);

    ValueAnimator valueAnimator =
        ValueAnimator.ofPropertyValuesHolder(scaleHolder, translateHolder, alphaHolder);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        target.setScaleX((Float) animation.getAnimatedValue("scale"));
        target.setScaleY((Float) animation.getAnimatedValue("scale"));
        target.setTranslationY((Float) animation.getAnimatedValue("translate"));
        target.setAlpha((Float) animation.getAnimatedValue("alpha"));
      }
    });

    getAnimator().play(valueAnimator);
  }
}
