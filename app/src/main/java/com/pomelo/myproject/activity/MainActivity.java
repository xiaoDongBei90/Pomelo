package com.pomelo.myproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pomelo.myproject.R;
import com.pomelo.myproject.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btnRVDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findView();
        setListener();
    }

    private void findView() {
        btnRVDemo = (Button) findViewById(R.id.btn_rv_demo);
    }

    private void setListener() {
        btnRVDemo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_rv_demo:
                startActivity(new Intent(this,RvDemoActivity.class));
                break;
        }
    }
}
