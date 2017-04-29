package mopel.io.library.fade;

import android.animation.ObjectAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/4/25
 * cssAnimation: https://github.com/daneden/animate.css/blob/master/source/fading_entrances/fadeInUpBig.css
 */

public class FadeInUpBigAnimator extends BaseAnimator {
  @Override protected void prepare(View target) {
    getAnimator().playTogether(ObjectAnimator.ofFloat(target, "alpha", 0, 1),
        ObjectAnimator.ofFloat(target, "translationY", 2000, 0));
  }
}
