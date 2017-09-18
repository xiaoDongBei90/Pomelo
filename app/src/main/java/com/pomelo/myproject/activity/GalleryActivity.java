package com.pomelo.myproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.pomelo.myproject.adapter.GalleryAdapter;
import com.pomelo.myproject.MyRecyclerView;
import com.pomelo.myproject.R;

public class GalleryActivity extends AppCompatActivity implements GalleryAdapter.OnItemChickListener, MyRecyclerView.OnItemScrollChangeListener {

    private MyRecyclerView mGrallery_recyclerview;
    private ImageView mImage_content;
    private int[] belle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        initView();
        initData();
    }

    private void initView() {

        mGrallery_recyclerview = (MyRecyclerView) findViewById(R.id.grallery_recyclerview);
        mImage_content = (ImageView) findViewById(R.id.image_content);
    }

    private void initData() {
        belle = new int[]{R.mipmap.pic11, R.mipmap.pic22, R.mipmap.pic33, R.mipmap.pic44,
                R.mipmap.pic55, R.mipmap.pic66, R.mipmap.pic77, R.mipmap.pic88, R.mipmap.pic99};
        GalleryAdapter galleryAdapter = new GalleryAdapter(this, belle);
        mGrallery_recyclerview.setAdapter(galleryAdapter);
        //设置recyclerview的布局管理器
        mGrallery_recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        galleryAdapter.setOnItemChickListener(this);
        mGrallery_recyclerview.setOnItemScrollChangeListener(this);

    }

    @Override
    public void itemClick(int position) {
        mImage_content.setImageResource(belle[position]);
    }

    @Override
    public void change(View view, int position) {
        mImage_content.setImageResource(belle[position]);
    }
}
