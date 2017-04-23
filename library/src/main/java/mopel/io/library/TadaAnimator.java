package mopel.io.library;

import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Author: mopel
 * Date : 2017/4/23
 * cssAnimation: link https://github.com/daneden/animate.css/blob/master/source/attention_seekers/tada.css
 *
 */

public class TadaAnimator extends BaseAnimator{
  @Override protected void prepare(View target) {
    getAnimator().playTogether(
        ObjectAnimator.ofFloat(target, "scaleX", 1, 0.9f, 0.9f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1),
        ObjectAnimator.ofFloat(target, "scaleY", 1, 0.9f, 0.9f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1),
        ObjectAnimator.ofFloat(target, "rotation", 0, -3, -3, 3, -3, 3, -3, 3, -3, 0)
    );
  }
}
