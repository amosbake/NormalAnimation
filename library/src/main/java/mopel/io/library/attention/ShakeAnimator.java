package mopel.io.library.attention;

import android.animation.ObjectAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/4/23
 * cssAnimation: link https://github.com/daneden/animate.css/blob/master/source/attention_seekers/shake.css
 */

public class ShakeAnimator extends BaseAnimator {
  @Override protected void prepare(View target) {
    getAnimator().play(
        ObjectAnimator.ofFloat(target, "translationX", 0, -10, 10, -10, 10, -10, 10, -10, 10, 0));
  }
}
