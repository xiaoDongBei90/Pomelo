package com.pomelo.myproject.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by paul on 2017/10/15.
 * Description:图片加载库
 */

public class ImageLoader {
    private static ImageLoader instance;

    public static ImageLoader getInstance() {
        if (instance == null) {
            synchronized (ImageLoader.class) {
                if (instance == null) {
                    instance = new ImageLoader();
                }
            }
        }
        return instance;
    }

    public void showImage(Context context, String url, int placeHolder, ImageView view) {
        Glide.with(context).load(url).placeholder(placeHolder).into(view);
    }
}
