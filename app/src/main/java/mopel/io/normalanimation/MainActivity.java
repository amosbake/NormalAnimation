package mopel.io.normalanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import mopel.io.library.BaseAnimator;
import mopel.io.library.flip.FlipOutYAnimator;

public class MainActivity extends AppCompatActivity {
  private ImageView target;
  private BaseAnimator animator;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    target = (ImageView) findViewById(R.id.animatorTarget);
    animator = new FlipOutYAnimator();
    animator.setStartDelay(500);
    animator.setDuration(2000);
    animator.addAnimatorListener(new AnimatorListenerAdapter() {
       Animator animator;

      @Override public void onAnimationEnd(Animator animation) {
        this.animator = animation;
        super.onAnimationEnd(animation);
        this.animator.start();
      }
    });
    target.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        animator.setTarget(target);
        animator.reset(target);
        animator.animate();
      }
    });
  }
}
