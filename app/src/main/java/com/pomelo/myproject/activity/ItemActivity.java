package com.pomelo.myproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.pomelo.myproject.R;

/**
 * Created by lixiaowei on 2016/9/26.
 */
public class ItemActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 1);
        TextView tv = (TextView) findViewById(R.id.haha);
        tv.setText("哈哈哈哈哈"+position);
    }
}
