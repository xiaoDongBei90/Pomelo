package com.pomelo.myproject;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lxw on 16/10/16.
 */
public class MyRecyclerView extends RecyclerView {
    private OnItemScrollChangeListener mOnItemScrollChangeListener;
    private View currentView;

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        currentView = getChildAt(0);
        if (mOnItemScrollChangeListener != null) {
            mOnItemScrollChangeListener.change(currentView, getChildPosition(currentView));
        }
    }

    public interface OnItemScrollChangeListener {
        void change(View view, int position);
    }

    public void setOnItemScrollChangeListener(OnItemScrollChangeListener onItemScrollChangeListener) {
        mOnItemScrollChangeListener = onItemScrollChangeListener;
    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
        View newView = getChildAt(0);
        if (mOnItemScrollChangeListener != null) {
            if (newView != null && newView != currentView) {
                currentView = newView;
                mOnItemScrollChangeListener.change(currentView, getChildPosition(currentView));

            }
        }
    }
}
