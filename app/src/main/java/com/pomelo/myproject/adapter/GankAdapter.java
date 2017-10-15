package com.pomelo.myproject.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.pomelo.myproject.R;
import com.pomelo.myproject.bean.GankIoDataBean;
import com.pomelo.myproject.utils.ImageLoader;

import java.util.List;

/**
 * Created by paul on 2017/10/15.
 * Description:
 */

public class GankAdapter extends BaseQuickAdapter<GankIoDataBean.ResultsBean, BaseViewHolder> {
    private Context context;


    public GankAdapter(@LayoutRes int layoutResId, @Nullable List<GankIoDataBean.ResultsBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, GankIoDataBean.ResultsBean item) {
        ImageLoader.getInstance().showImage(context, item.getUrl(), R.mipmap.ic_launcher, (ImageView) helper.getView(R.id.iv_girl));
    }

}
