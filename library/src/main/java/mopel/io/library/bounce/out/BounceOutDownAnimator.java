package mopel.io.library.bounce.out;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/5/3
 * https://github.com/daneden/animate.css/blob/master/source/bouncing_exits/bounceOutDown.css
 */

public class BounceOutDownAnimator extends BaseAnimator {

  @Override protected void prepare(final View target) {
    Keyframe kf_scale_1 = Keyframe.ofFloat(0, 0);
    Keyframe kf_scale_2 = Keyframe.ofFloat(.2f, 10f);
    Keyframe kf_scale_3 = Keyframe.ofFloat(.4f, -20);
    Keyframe kf_scale_4 = Keyframe.ofFloat(.45f, 2000);
    Keyframe kf_scale_5 = Keyframe.ofFloat(1, .3f);

    PropertyValuesHolder scaleHolder =
        PropertyValuesHolder.ofKeyframe("translation", kf_scale_1, kf_scale_2, kf_scale_3,
            kf_scale_4, kf_scale_5);

    Keyframe kf_alpha_1 = Keyframe.ofFloat(0, 1);
    Keyframe kf_alpha_2 = Keyframe.ofFloat(.45f, 1);
    Keyframe kf_alpha_3 = Keyframe.ofFloat(1, 0);

    PropertyValuesHolder alphaHolder =
        PropertyValuesHolder.ofKeyframe("alpha", kf_alpha_1, kf_alpha_2, kf_alpha_3);

    ValueAnimator valueAnimator = ValueAnimator.ofPropertyValuesHolder(scaleHolder, alphaHolder);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        target.setAlpha((Float) animation.getAnimatedValue("alpha"));
        target.setTranslationY((Float) animation.getAnimatedValue("translation"));
      }
    });
    getAnimator().play(valueAnimator);
  }
}
