package com.pomelo.myproject.base;

/**
 * Created by paul on 2017/9/21.
 * github: https://github.com/xiaoDongBei90
 * Description:recyclerview条目点击接口
 */

public interface OnItemClickListener<T> {
    public void onClick(T t, int position);
}
