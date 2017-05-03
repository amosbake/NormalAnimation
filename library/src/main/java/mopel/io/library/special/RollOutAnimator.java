package mopel.io.library.special;

import android.animation.ObjectAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/5/2
 */

public class RollOutAnimator extends BaseAnimator {
  @Override protected void prepare(final View target) {

    getAnimator().playTogether(ObjectAnimator.ofFloat(target, "alpha", 1, 0),
        ObjectAnimator.ofFloat(target, "translationX", 0, target.getWidth()),
        ObjectAnimator.ofFloat(target, "rotation", 0, 120));
  }
}
