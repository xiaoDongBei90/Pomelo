package com.pomelo.myproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pomelo.myproject.ItemAnimator;
import com.pomelo.myproject.R;
import com.pomelo.myproject.adapter.RVAdapter;
import com.pomelo.myproject.SpaceItemDecoration;

import java.util.ArrayList;

public class DemoActivity1 extends AppCompatActivity implements RVAdapter.OnRVItemClickListener, RVAdapter.OnRVItemLongClickListener {

    private RecyclerView mRecyclerView;
    private RVAdapter mRVAdapter;
    private ArrayList<String> mList;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //测试哈哈1
        //测试哈哈2
        //测试哈哈3
        setContentView(R.layout.activity_demo1);
        initView();
        initData();
        initListener();
        initAnimation();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //设置条目间间距
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(10));
        //设置LayoutManager
        Intent intent = getIntent();
        String lvIntent = intent.getStringExtra("listview");
        String gvIntent = intent.getStringExtra("gridview");
        String gridview21 = intent.getStringExtra("gridview21");
        if (lvIntent != null) {
            mLayoutManager = new LinearLayoutManager(this);
        }
        if (gvIntent != null) {
            mLayoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        }
        if (gridview21 != null) {
            mLayoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.HORIZONTAL, false);
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mList.add("呵呵呵" + i);
        }
        //设置适配器
        mRVAdapter = new RVAdapter(this, mList);
        mRecyclerView.setAdapter(mRVAdapter);
    }

    private void initListener() {
        mRVAdapter.setOnRVItemClickListener(this);
        mRVAdapter.setOnRVItemLongClickListener(this);
    }

    private void initAnimation() {
        ItemAnimator itemAnimator = new ItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setSupportsChangeAnimations(true);
        mRecyclerView.setItemAnimator(itemAnimator);
    }

    @Override
    public void onChildClick(RecyclerView parent, View view, int position, String data) {
        Intent intent = new Intent(this, ItemActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);

    }

    @Override
    public void onChildLongClick(RecyclerView parent, View view, int position, String data) {
        mRVAdapter.add(position, "新增条目" + position);
    }
}
