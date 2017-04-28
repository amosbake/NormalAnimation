package mopel.io.library.zoom.out;

import android.animation.ObjectAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/4/25
 * cssAnimation: https://github.com/daneden/animate.css/blob/master/source/zooming_exits/zoomOut.css
 */

public class ZoomOutAnimator extends BaseAnimator {
  @Override protected void prepare(View target) {
    getAnimator().playTogether(ObjectAnimator.ofFloat(target, "scaleX", 1f, .3f, 0f),
        ObjectAnimator.ofFloat(target, "scaleY", 1f, .3f, 0f),
        ObjectAnimator.ofFloat(target, "alpha", 1f, 0f, 0f));
  }
}
