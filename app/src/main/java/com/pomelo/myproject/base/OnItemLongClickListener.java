package com.pomelo.myproject.base;

/**
 * Created by paul on 2017/9/21.
 * github: https://github.com/xiaoDongBei90
 * Description:recyclerview条目长按接口
 */

public interface OnItemLongClickListener<T> {
    public void onLongClick(T t, int position);
}
