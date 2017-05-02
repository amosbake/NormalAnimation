package mopel.io.library.slide.out;

import android.animation.ObjectAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/4/30
 * https://github.com/daneden/animate.css/blob/master/source/sliding_exits/slideOutDown.css
 */

public class SlideOutDownAnimator extends BaseAnimator {
  @Override protected void prepare(final View target) {
    getAnimator().play(ObjectAnimator.ofFloat(target, "translationY", 0, target.getHeight()));
  }
}
