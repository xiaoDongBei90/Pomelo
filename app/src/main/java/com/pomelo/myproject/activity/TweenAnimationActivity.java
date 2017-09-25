package com.pomelo.myproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.pomelo.myproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TweenAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.iv_display_alpha)
    ImageView ivDisplayAlpha;
    @BindView(R.id.tv_alpha)
    TextView tvAlpha;
    @BindView(R.id.iv_display_rotate)
    ImageView ivDisplayRotate;
    @BindView(R.id.tv_rotate)
    TextView tvRotate;
    @BindView(R.id.iv_display_scale)
    ImageView ivDisplayScale;
    @BindView(R.id.tv_scale)
    TextView tvScale;
    @BindView(R.id.iv_display_translate)
    ImageView ivDisplayTranslate;
    @BindView(R.id.tv_translate)
    TextView tvTranslate;
    @BindView(R.id.tv_animation_set)
    TextView tvAnimationSet;
    @BindView(R.id.iv_display_set)
    ImageView ivDisplaySet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        ButterKnife.bind(this);
        setListener();
    }

    private void setListener() {
        tvAlpha.setOnClickListener(this);
        tvRotate.setOnClickListener(this);
        tvScale.setOnClickListener(this);
        tvTranslate.setOnClickListener(this);
        tvAnimationSet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_alpha:
                alphaAnimation(ivDisplayAlpha);
                break;
            case R.id.tv_rotate:
                rotateAnimation(ivDisplayRotate);
                break;
            case R.id.tv_scale:
                scaleAnimation(ivDisplayScale);
                break;
            case R.id.tv_translate:
                translateAnimation(ivDisplayTranslate);
                break;
            case R.id.tv_animation_set:
                animationSet(ivDisplaySet);
                break;
        }
    }

    public void alphaAnimation(View view) {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500);
        view.startAnimation(alphaAnimation);
    }

    public void rotateAnimation(View view) {
        Animation rotateAnimation = new RotateAnimation(0.0f, 360f, view.getWidth() / 2, view.getHeight() / 2);
        rotateAnimation.setDuration(1000);
        view.startAnimation(rotateAnimation);
    }

    public void scaleAnimation(View view) {
        Animation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, view.getWidth() / 2, view.getHeight() / 2);
        scaleAnimation.setDuration(1000);
        view.startAnimation(scaleAnimation);
    }

    public void translateAnimation(View view) {
        Animation translateAnimation = new TranslateAnimation(0.0f, -600f, 0.0f, 1000f);
        translateAnimation.setDuration(1000);
        view.startAnimation(translateAnimation);
    }

    public void animationSet(View view) {
        AnimationSet animationSet = new AnimationSet(this, null);
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        animationSet.setDuration(1000);
        Animation rotateAnimation = new RotateAnimation(0.0f, 270f, view.getWidth() / 2, view.getHeight() / 2);
        animationSet.setDuration(1000);
        Animation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, view.getWidth() / 2, view.getHeight() / 2);
        animationSet.setDuration(1000);
        Animation translateAnimation = new TranslateAnimation(0.0f, -600f, 0.0f, 1000f);
        animationSet.setDuration(1000);
        //animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        //animationSet.addAnimation(translateAnimation);
        view.startAnimation(animationSet);
    }
}
