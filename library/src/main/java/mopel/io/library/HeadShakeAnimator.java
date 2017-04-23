package mopel.io.library;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;

/**
 * Author: mopel
 * Date : 2017/4/23
 */

public class HeadShakeAnimator extends BaseAnimator {

  @Override protected void prepare(final View target) {
    Keyframe[] transX = new Keyframe[11];
    transX[0] = Keyframe.ofFloat(0f, 0f);
    transX[1] = Keyframe.ofFloat(0.065f, -6f);
    transX[2] = Keyframe.ofFloat(0.185f, 5f);
    transX[3] = Keyframe.ofFloat(0.315f, -3f);
    transX[4] = Keyframe.ofFloat(0.435f, 2f);
    transX[5] = Keyframe.ofFloat(0.5f, 0f);
    transX[6] = Keyframe.ofFloat(0.565f, -2f);
    transX[7] = Keyframe.ofFloat(0.685f, 3f);
    transX[8] = Keyframe.ofFloat(0.815f, -5f);
    transX[9] = Keyframe.ofFloat(0.93f, -6f);
    transX[10] = Keyframe.ofFloat(1f, 0f);

    PropertyValuesHolder holderX = PropertyValuesHolder.ofKeyframe("transitionX", transX);

    Keyframe[] rotateFrames = new Keyframe[11];
    rotateFrames[0] = Keyframe.ofFloat(0f, 0f);
    rotateFrames[1] = Keyframe.ofFloat(0.065f, -9f);
    rotateFrames[2] = Keyframe.ofFloat(0.185f, 7f);
    rotateFrames[3] = Keyframe.ofFloat(0.315f, -5f);
    rotateFrames[4] = Keyframe.ofFloat(0.435f, 3f);
    rotateFrames[5] = Keyframe.ofFloat(0.5f, 0f);
    rotateFrames[6] = Keyframe.ofFloat(0.565f, -3f);
    rotateFrames[7] = Keyframe.ofFloat(0.685f, 5f);
    rotateFrames[8] = Keyframe.ofFloat(0.815f, -7f);
    rotateFrames[9] = Keyframe.ofFloat(0.93f, -9f);
    rotateFrames[10] = Keyframe.ofFloat(1f, 0f);

    PropertyValuesHolder rotate = PropertyValuesHolder.ofKeyframe("rotate", rotateFrames);

    ValueAnimator animator = ValueAnimator.ofPropertyValuesHolder(holderX, rotate);
    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        target.setTranslationX((Float) animation.getAnimatedValue("transitionX"));
        target.setRotation((Float) animation.getAnimatedValue("rotate"));
      }
    });

    getAnimator().play(animator);
  }
}
