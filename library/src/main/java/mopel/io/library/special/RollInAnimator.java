package mopel.io.library.special;

import android.animation.ObjectAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/5/2
 */

public class RollInAnimator extends BaseAnimator {
  @Override protected void prepare(final View target) {

    getAnimator().playTogether(ObjectAnimator.ofFloat(target, "alpha", 0, 1),
        ObjectAnimator.ofFloat(target, "translationX", -target.getWidth(), 0),
        ObjectAnimator.ofFloat(target, "rotation", -120, 0));
  }
}
