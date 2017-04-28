package mopel.io.library.zoom.out;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/4/25
 * cssAnimation: https://github.com/daneden/animate.css/blob/master/source/zooming_exits/zoomOutLeft.css
 */

public class ZoomOutLeftAnimator extends BaseAnimator {

  @Override protected void prepare(final View target) {
    Keyframe kf_scale_1 = Keyframe.ofFloat(0, 1f);
    Keyframe kf_scale_2 = Keyframe.ofFloat(.4f, .475f);
    Keyframe kf_scale_3 = Keyframe.ofFloat(1, .1f);
    PropertyValuesHolder scaleHolder =
        PropertyValuesHolder.ofKeyframe("scale", kf_scale_1, kf_scale_2, kf_scale_3);

    Keyframe kf_translation_1 = Keyframe.ofFloat(0, 0);
    Keyframe kf_translation_2 = Keyframe.ofFloat(.4f, 42);
    Keyframe kf_translation_3 = Keyframe.ofFloat(1, -2000);
    PropertyValuesHolder translateHolder =
        PropertyValuesHolder.ofKeyframe("translate", kf_translation_1, kf_translation_2,
            kf_translation_3);

    Keyframe kf_alpha_1 = Keyframe.ofFloat(0, 1f);
    Keyframe kf_alpha_2 = Keyframe.ofFloat(.4f, 0f);
    Keyframe kf_alpha_3 = Keyframe.ofFloat(1, 0f);
    PropertyValuesHolder alphaHolder =
        PropertyValuesHolder.ofKeyframe("alpha", kf_alpha_1, kf_alpha_2, kf_alpha_3);

    ValueAnimator valueAnimator =
        ValueAnimator.ofPropertyValuesHolder(scaleHolder, translateHolder, alphaHolder);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        target.setScaleX((Float) animation.getAnimatedValue("scale"));
        target.setScaleY((Float) animation.getAnimatedValue("scale"));
        target.setTranslationX((Float) animation.getAnimatedValue("translate"));
        target.setAlpha((Float) animation.getAnimatedValue("alpha"));
      }
    });

    getAnimator().play(valueAnimator);
  }
}
