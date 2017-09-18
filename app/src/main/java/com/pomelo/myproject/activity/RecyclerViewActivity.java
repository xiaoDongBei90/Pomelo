package com.pomelo.myproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.pomelo.myproject.R;


/**
 * Created by lixiaowei on 2016/10/9.
 */

public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTv_listview;
    private TextView mTv_gridview;
    private TextView mTv_gridview21;
    private TextView mTv_stagger2;
    private TextView mTv_stagger3;
    private TextView mTv_stagger4;
    private TextView mTv_gallery;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        initView();
        initListener();
    }

    private void initView() {
        mTv_listview = (TextView) findViewById(R.id.tv1);
        mTv_gridview = (TextView) findViewById(R.id.tv2);
        mTv_gridview21 = (TextView) findViewById(R.id.tv21);
        mTv_stagger2 = (TextView) findViewById(R.id.tv3);
        mTv_stagger3 = (TextView) findViewById(R.id.tv4);
        mTv_stagger4 = (TextView) findViewById(R.id.tv5);
        mTv_gallery = (TextView) findViewById(R.id.tv6);

    }

    private void initListener() {
        mTv_listview.setOnClickListener(this);
        mTv_gridview.setOnClickListener(this);
        mTv_gridview21.setOnClickListener(this);
        mTv_stagger2.setOnClickListener(this);
        mTv_stagger3.setOnClickListener(this);
        mTv_stagger4.setOnClickListener(this);
        mTv_gallery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                Intent intent1 = new Intent(this, DemoActivity1.class);
                intent1.putExtra("listview", "listview");
                startActivity(intent1);
                break;
            case R.id.tv2:
                Intent intent2 = new Intent(this, DemoActivity1.class);
                intent2.putExtra("gridview", "gridview");
                startActivity(intent2);
                break;
            case R.id.tv21:
                Intent intent21 = new Intent(this, DemoActivity1.class);
                intent21.putExtra("gridview21", "gridview21");
                startActivity(intent21);
                break;
            case R.id.tv3:
                Intent intent3 = new Intent(this, StaggerDemoActivity.class);
                intent3.putExtra("two", "two");
                startActivity(intent3);
                break;
            case R.id.tv4:
                Intent intent4 = new Intent(this, StaggerDemoActivity.class);
                intent4.putExtra("three", "three");
                startActivity(intent4);
                break;
            case R.id.tv5:
                Intent intent5 = new Intent(this, StaggerDemoActivity.class);
                intent5.putExtra("four", "four");
                startActivity(intent5);
                break;
            case R.id.tv6:
                Intent intent6 = new Intent(this, GalleryActivity.class);
                startActivity(intent6);
                break;
        }
    }
}
