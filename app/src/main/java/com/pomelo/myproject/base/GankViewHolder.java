package com.pomelo.myproject.base;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.pomelo.myproject.R;

/**
 * Created by paul on 2017/10/15.
 * Description:
 */

public class GankViewHolder extends BaseViewHolder {

    private final ImageView ivGirl;

    public GankViewHolder(View view) {
        super(view);
        ivGirl = (ImageView) view.findViewById(R.id.iv_girl);
    }
}
