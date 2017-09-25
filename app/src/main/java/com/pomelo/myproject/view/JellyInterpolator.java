package com.pomelo.myproject.view;

import android.view.animation.LinearInterpolator;

/**
 * Created by paul on 2017/9/22.
 * github: https://github.com/xiaoDongBei90
 * Description:自定义动画差值器
 */

public class JellyInterpolator extends LinearInterpolator {
    private float factor;

    public JellyInterpolator() {
        this.factor = 0.15f;
    }

    @Override
    public float getInterpolation(float input) {
        return (float) (Math.pow(2, -10 * input)
                * Math.sin((input - factor / 4) * (2 * Math.PI) / factor) + 1);
    }
}
