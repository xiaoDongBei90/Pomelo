package com.pomelo.myproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.pomelo.myproject.R;
import com.pomelo.myproject.adapter.GankAdapter;
import com.pomelo.myproject.bean.GankIoDataBean;
import com.pomelo.myproject.http.HttpUtils;
import com.pomelo.myproject.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RvDemoActivity extends AppCompatActivity {
    private int page = 1;
    private int pre_page = 10;
    private RecyclerView rvGank;
    private GankAdapter gankAdapter;
    private List<GankIoDataBean.ResultsBean> gankIoDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_demo);
        init();
        getGankData(page);
    }

    private void init() {
        rvGank = (RecyclerView) findViewById(R.id.rv_gank);
        rvGank.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        gankIoDataList = new ArrayList<>();
        gankAdapter = new GankAdapter(R.layout.item_gank, gankIoDataList, RvDemoActivity.this);
        gankAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        gankAdapter.isFirstOnly(false);
        gankAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                page++;
                getGankData(page);
            }
        });
        rvGank.setAdapter(gankAdapter);
    }

    private void getGankData(int paeg) {
        Call<GankIoDataBean> gankIoData = HttpUtils.getInstance().getPomeloApi().getGankIoData("福利", pre_page, page);
        gankIoData.enqueue(new Callback<GankIoDataBean>() {
            @Override
            public void onResponse(Call<GankIoDataBean> call, Response<GankIoDataBean> response) {
                List<GankIoDataBean.ResultsBean> results = response.body().getResults();
                gankIoDataList.addAll(results);
                gankAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GankIoDataBean> call, Throwable t) {
                LogUtils.d("pomelo_tag", t.toString());
            }
        });
    }
}
