package com.pomelo.myproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.pomelo.myproject.ItemAnimator;
import com.pomelo.myproject.R;
import com.pomelo.myproject.SpaceItemDecoration;
import com.pomelo.myproject.adapter.StaggerAdapter;

import java.util.ArrayList;

public class StaggerDemoActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView2;
    private ArrayList<String> mList;
    private RecyclerView.LayoutManager mLayoutManager;
    private StaggerAdapter mStaggerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        initView();
        initData();
        initListener();
        initAnimation();
    }

    private void initView() {
        mRecyclerView2 = (RecyclerView) findViewById(R.id.recyclerview2);
        //设置条目间间距
    }

    private void initData() {
        Intent intent = getIntent();
        String two = intent.getStringExtra("two");
        String three = intent.getStringExtra("three");
        String four = intent.getStringExtra("four");
        mList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mList.add("呵呵呵" + i);
        }
        //设置LayoutManager
        if (two != null) {
            mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        }
        if (three != null) {
            mLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        }
        if (four != null) {
            mLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        }
        mRecyclerView2.setLayoutManager(mLayoutManager);
        //设置适配器
        mStaggerAdapter = new StaggerAdapter(this, mList);
        mRecyclerView2.setAdapter(mStaggerAdapter);

        mRecyclerView2.addItemDecoration(new SpaceItemDecoration(10));
    }

    private void initListener() {
    }

    private void initAnimation() {
        ItemAnimator itemAnimator = new ItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setSupportsChangeAnimations(true);
        mRecyclerView2.setItemAnimator(itemAnimator);
    }


}
