package mopel.io.library.zoom.in;

import android.animation.ObjectAnimator;
import android.view.View;
import mopel.io.library.BaseAnimator;

/**
 * Author: mopel
 * Date : 2017/4/25
 * cssAnimation: https://github.com/daneden/animate.css/blob/master/source/zooming_entrances/zoomIn.css
 */

public class ZoomInAnimator extends BaseAnimator {
  @Override protected void prepare(View target) {
    getAnimator().playTogether(ObjectAnimator.ofFloat(target, "scaleX", 0f, 0.3f, 1f),
        ObjectAnimator.ofFloat(target, "scaleY", 0f, 0.3f, 1f),
        ObjectAnimator.ofFloat(target, "alpha", 0f, 1f, 1f));
  }
}
