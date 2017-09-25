package com.pomelo.myproject.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pomelo.myproject.R;
import com.pomelo.myproject.utils.LogUtils;
import com.pomelo.myproject.view.JellyInterpolator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin;
    private ProgressBar loginProgressbar;
    private TextView mTextMessage, mTvStop;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById(R.id.btn_login);
        loginProgressbar = (ProgressBar) findViewById(R.id.login_progressbar);
        mTextMessage = (TextView) findViewById(R.id.message);
        mTvStop = (TextView) findViewById(R.id.tv_stop);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        btnLogin.setOnClickListener(this);
        mTvStop.setOnClickListener(this);
    }

    public void loginAnimator(final View view, float width, float height) {
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, width);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                layoutParams.leftMargin = (int) animatedValue;
                layoutParams.rightMargin = (int) animatedValue;
                view.setLayoutParams(layoutParams);
            }
        });

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btnLogin, "scaleX", 1.0f, 0.3f);
        animatorSet.setDuration(1000);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.playTogether(valueAnimator, objectAnimator);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                loginProgressbar.setVisibility(View.VISIBLE);
                //progressAnimator(loginProgressbar);
                btnLogin.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    public void progressAnimator(View view) {
        PropertyValuesHolder animator1 = PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f);
        PropertyValuesHolder animator2 = PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f);
        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(view, animator1, animator2);
        animator3.setDuration(1000);
        animator3.setInterpolator(new JellyInterpolator());
        animator3.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                LogUtils.e("testkk", "登录了");
                int measuredWidth = btnLogin.getMeasuredWidth();
                int measuredHeight = btnLogin.getMeasuredHeight();
                loginAnimator(btnLogin, measuredWidth, measuredHeight);
                break;
            case R.id.tv_stop:
                loginProgressbar.setVisibility(View.GONE);
                btnLogin.setVisibility(View.VISIBLE);
                break;
        }
    }
}
