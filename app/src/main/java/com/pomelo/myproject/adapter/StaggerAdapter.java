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


public class StaggerAdapter extends RecyclerView.Adapter<StaggerAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<String> mList;
    private RecyclerView recyclerView;
    private final ArrayList<Integer> mHeight;
    private int[] arr = new int[]{R.mipmap.pic1, R.mipmap.pic2, R.mipmap.pic3, R.mipmap.pic4, R.mipmap.pic5, R.mipmap.pic6};


    public StaggerAdapter(Context context, ArrayList<String> mList) {
        this.mContext = context;
        this.mList = mList;
        mHeight = new ArrayList<>();

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item2, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.mTextView.getLayoutParams();
        if (mHeight.size() <= position) {
            mHeight.add((int) (80 + Math.random() * 80));
        }
        layoutParams.height = mHeight.get(position);
        holder.mTextView.setLayoutParams(layoutParams);
        holder.mTextView.setText(mList.get(position));
        holder.mImageView.setImageResource(arr[position%arr.length]);
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

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTextView;
        private final ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_content2);
            mImageView = (ImageView) itemView.findViewById(R.id.imageview);
        }
    }

}
