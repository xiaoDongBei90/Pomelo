package com.pomelo.myproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pomelo.myproject.R;

/**
 * Created by lxw on 16/10/16.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private int[] belle;
    private RecyclerView mRecyclerView;

    public void setOnItemChickListener(OnItemChickListener onItemChickListener) {
        mOnItemChickListener = onItemChickListener;
    }

    private OnItemChickListener mOnItemChickListener;

    public GalleryAdapter(Context context, int[] belle) {
        this.mContext = context;
        this.belle = belle;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.gallery_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mGrallery_img.setImageResource(belle[position % belle.length]);
    }

    @Override
    public int getItemCount() {
        return belle.length;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mRecyclerView = null;
    }

    @Override
    public void onClick(View view) {
        if (mRecyclerView != null && mOnItemChickListener != null) {
            int position = mRecyclerView.getChildAdapterPosition(view);
            mOnItemChickListener.itemClick(position);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mGrallery_img;

        public ViewHolder(View itemView) {
            super(itemView);
            mGrallery_img = (ImageView) itemView.findViewById(R.id.grallery_img);
        }
    }

    public interface OnItemChickListener {
        void itemClick(int position);
    }
}
