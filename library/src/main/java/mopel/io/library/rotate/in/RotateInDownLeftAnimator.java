package mopel.io.library.rotate.in;

import android.animation.ObjectAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/4/25
 * cssAnimation: https://github.com/daneden/animate.css/blob/master/source/rotating_entrances/rotateInDownLeft.css
 */

public class RotateInDownLeftAnimator extends BaseAnimator {
  @Override protected void prepare(View target) {
    target.setPivotX(0f);
    target.setPivotY(target.getHeight());
    getAnimator().playTogether(ObjectAnimator.ofFloat(target, "rotation", -45, 0),
        ObjectAnimator.ofFloat(target, "alpha", 0f, 1f));
  }
}
