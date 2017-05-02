package mopel.io.library.slide.in;

import android.animation.ObjectAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/4/30
 * https://github.com/daneden/animate.css/blob/master/source/sliding_entrances/slideInLeft.css
 */

public class SlideInLeftAnimator extends BaseAnimator {
  @Override protected void prepare(final View target) {
    getAnimator().play(ObjectAnimator.ofFloat(target, "translationX", -target.getWidth(), 0));
  }
}
