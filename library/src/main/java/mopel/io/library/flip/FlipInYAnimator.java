package mopel.io.library.flip;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;
import mopel.io.library.CubicBezierInterpolator;

/**
 * Author: mopel
 * Date : 2017/4/30
 * https://github.com/daneden/animate.css/blob/master/source/flippers/flipInY.css
 */

public class FlipInYAnimator extends BaseAnimator {
  @Override protected void prepare(final View target) {
    Keyframe kf_rotation_1 = Keyframe.ofFloat(0, 90f);
    kf_rotation_1.setInterpolator(CubicBezierInterpolator.EaseInBezierInterpolator());
    Keyframe kf_rotation_2 = Keyframe.ofFloat(.4f, -15f);
    kf_rotation_2.setInterpolator(CubicBezierInterpolator.EaseInBezierInterpolator());
    Keyframe kf_rotation_3 = Keyframe.ofFloat(.6f, 10f);
    Keyframe kf_rotation_4 = Keyframe.ofFloat(.8f, -5f);
    Keyframe kf_rotation_5 = Keyframe.ofFloat(1f, 0f);

    Keyframe kf_alpha_1 = Keyframe.ofFloat(0, 0);
    kf_alpha_1.setInterpolator(CubicBezierInterpolator.EaseInBezierInterpolator());
    Keyframe kf_alpha_2 = Keyframe.ofFloat(.6f, 1);

    PropertyValuesHolder rotationValue =
        PropertyValuesHolder.ofKeyframe("rotation", kf_rotation_1, kf_rotation_2, kf_rotation_3,
            kf_rotation_4, kf_rotation_5);
    PropertyValuesHolder alphaValue =
        PropertyValuesHolder.ofKeyframe("alpha", kf_alpha_1, kf_alpha_2);
    ValueAnimator rotation = ValueAnimator.ofPropertyValuesHolder(rotationValue, alphaValue);
    rotation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        target.setRotationY((Float) animation.getAnimatedValue("rotation"));
        target.setAlpha((Float) animation.getAnimatedValue("alpha"));
      }
    });
    getAnimator().play(rotation);
  }
}
