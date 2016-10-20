package com.vivi.animatormenu;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] res = {R.id.imageView_open, R.id.imageView_camera, R.id.imageView_music, R.id.imageView_place,
            R.id.imageView_sleep, R.id.imageView_thought, R.id.imageView_with};

    private List<ImageView> imageViewList = new ArrayList<ImageView>();
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < res.length; i++) {
            ImageView imageView = (ImageView) findViewById(res[i]);
            imageView.setOnClickListener(this);
            imageViewList.add(imageView);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView_open:
                if (flag) {
                    startAnim();
                } else {
                    cloneAnim();
                }

                break;
            default:
                Toast.makeText(MainActivity.this,"click"+v.getId(),Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void cloneAnim() {
        for (int i = 1; i < res.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", i * 300, 0F);
            animator.setDuration(300);
            animator.setInterpolator(new BounceInterpolator());
            animator.setStartDelay(i * 300);
            animator.start();
            flag = true;
        }
    }


    private void startAnim() {
        for (int i = 1; i < res.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", 0F, i * 300);
            animator.setDuration(300);
            animator.setInterpolator(new BounceInterpolator());
            animator.setStartDelay(i * 300);
            animator.start();
            flag = false;
        }
    }
}
