package com.pomelo.myproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pomelo.myproject.R;

import java.util.ArrayList;

/**
 * Created by lixiaowei on 2016/9/26.
 */


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    private Context mContext;
    private ArrayList<String> mList;
    private RecyclerView recyclerView;
    private OnRVItemClickListener onRVItemClickListener;
    private OnRVItemLongClickListener onRVItemLongClickListener;
    private int[] imageArr = {R.mipmap.pic1, R.mipmap.pic2, R.mipmap.pic3, R.mipmap.pic4, R.mipmap.pic5, R.mipmap.pic6,
            R.mipmap.pic11, R.mipmap.pic22, R.mipmap.pic33, R.mipmap.pic44, R.mipmap.pic55, R.mipmap.pic66, R.mipmap.pic77, R.mipmap.pic88, R.mipmap.pic99};

    public void setOnRVItemClickListener(OnRVItemClickListener onRVItemClickListener) {
        this.onRVItemClickListener = onRVItemClickListener;

    }

    public void setOnRVItemLongClickListener(OnRVItemLongClickListener onRVItemLongClickListener) {
        this.onRVItemLongClickListener = onRVItemLongClickListener;
    }

    public RVAdapter(Context context, ArrayList<String> mList) {
        this.mContext = context;
        this.mList = mList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item, parent, false);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position));
        holder.mIv_image.setImageResource(imageArr[position % imageArr.length]);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    @Override
    public void onClick(View v) {
        if (recyclerView != null && onRVItemClickListener != null) {
            int position = recyclerView.getChildAdapterPosition(v);
            onRVItemClickListener.onChildClick(recyclerView, v, position, mList.get(position));
        }

    }

    //长按点击事件
    @Override
    public boolean onLongClick(View v) {
        if (recyclerView != null && onRVItemLongClickListener != null) {
            int position = recyclerView.getChildAdapterPosition(v);
            onRVItemLongClickListener.onChildLongClick(recyclerView, v, position, mList.get(position));
        }
        return true;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTextView;
        private final ImageView mIv_image;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_content);
            mIv_image = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }

    public interface OnRVItemClickListener {
        void onChildClick(RecyclerView parent, View view, int position, String data);
    }

    public interface OnRVItemLongClickListener {
        void onChildLongClick(RecyclerView parent, View view, int position, String data);
    }


    public void add(int position, String data) {
        mList.add(position, data);
        notifyItemInserted(position);
    }
}
