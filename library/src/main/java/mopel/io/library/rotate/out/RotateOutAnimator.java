package mopel.io.library.rotate.out;

import android.animation.ObjectAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/4/25
 * cssAnimation: https://github.com/daneden/animate.css/blob/master/source/rotating_exits/rotateOut.css
 */

public class RotateOutAnimator extends BaseAnimator {
  @Override protected void prepare(View target) {
    getAnimator().playTogether(ObjectAnimator.ofFloat(target, "rotation", 200, 0),
        ObjectAnimator.ofFloat(target, "alpha", 1f, 0f));
  }
}
