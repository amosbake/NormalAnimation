package mopel.io.library.fade.out;

import android.animation.ObjectAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/4/25
 * cssAnimation: https://github.com/daneden/animate.css/blob/master/source/fading_exits/fadeOut.css
 */

public class FadeOutAnimator extends BaseAnimator {
  @Override protected void prepare(View target) {
    getAnimator().play(ObjectAnimator.ofFloat(target, "alpha", 1, 0));
  }
}
