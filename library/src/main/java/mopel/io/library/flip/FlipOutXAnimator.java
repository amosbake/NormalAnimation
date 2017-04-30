package mopel.io.library.flip;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/4/30
 * https://github.com/daneden/animate.css/blob/master/source/flippers/flipOutX.css
 */

public class FlipOutXAnimator extends BaseAnimator {
  @Override protected void prepare(final View target) {
    Keyframe kf_rotation_1 = Keyframe.ofFloat(0, 0);
    Keyframe kf_rotation_2 = Keyframe.ofFloat(1f, 90);

    Keyframe kf_alpha_1 = Keyframe.ofFloat(0f, 1);
    Keyframe kf_alpha_2 = Keyframe.ofFloat(1f, 0);

    PropertyValuesHolder rotationValue =
        PropertyValuesHolder.ofKeyframe("rotation", kf_rotation_1, kf_rotation_2);
    PropertyValuesHolder alphaValue =
        PropertyValuesHolder.ofKeyframe("alpha", kf_alpha_1, kf_alpha_2);
    ValueAnimator rotation = ValueAnimator.ofPropertyValuesHolder(rotationValue, alphaValue);
    rotation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        target.setRotationX((Float) animation.getAnimatedValue("rotation"));
        target.setAlpha((Float) animation.getAnimatedValue("alpha"));
      }
    });
    getAnimator().play(rotation);
  }
}
