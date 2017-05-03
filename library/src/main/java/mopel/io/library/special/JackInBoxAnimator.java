package mopel.io.library.special;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/5/2
 */

public class JackInBoxAnimator extends BaseAnimator {
  @Override protected void prepare(final View target) {
    target.setPivotX(target.getWidth() / 2);
    target.setPivotY(target.getHeight());
    Keyframe kf_rotate_1 = Keyframe.ofFloat(0, 30f);
    Keyframe kf_rotate_2 = Keyframe.ofFloat(.5f, -10f);
    Keyframe kf_rotate_3 = Keyframe.ofFloat(.7f, 3f);
    Keyframe kf_rotate_4 = Keyframe.ofFloat(1f, 0f);

    PropertyValuesHolder rotateHolder =
        PropertyValuesHolder.ofKeyframe("rotate", kf_rotate_1, kf_rotate_2, kf_rotate_3,
            kf_rotate_4);
    ValueAnimator rotate = ValueAnimator.ofPropertyValuesHolder(rotateHolder);
    rotate.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        target.setRotation((Float) animation.getAnimatedValue("rotate"));
      }
    });

    getAnimator().playTogether(ObjectAnimator.ofFloat(target, "alpha", 0, 1),
        ObjectAnimator.ofFloat(target, "scaleX", 0.1f, 1),
        ObjectAnimator.ofFloat(target, "scaleY", 0.1f, 1), rotate);
  }
}
