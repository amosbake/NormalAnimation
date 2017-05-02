package mopel.io.library.rotate.out;

import android.animation.ObjectAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/4/25
 * cssAnimation: https://github.com/daneden/animate.css/blob/master/source/rotating_exits/rotateOutUpRight.css
 */

public class RotateOutUpLeftAnimator extends BaseAnimator {
  @Override protected void prepare(View target) {
    target.setPivotX(0);
    target.setPivotY(target.getHeight());
    getAnimator().playTogether(ObjectAnimator.ofFloat(target, "rotation", 0, -45),
        ObjectAnimator.ofFloat(target, "alpha", 1, 0));
  }
}
