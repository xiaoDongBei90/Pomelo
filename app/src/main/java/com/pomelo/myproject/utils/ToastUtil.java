package com.pomelo.myproject.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static Boolean isShow = true;

    //短时Toast
    public static void showShortToast(Context context, String msg) {
        if (isShow) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showShortToast(Context context, int msg) {
        if (isShow) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

    //长时Toast
    public static void showLongToast(Context context, String msg) {
        if (isShow) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        }
    }

    public static void showLongToast(Context context, int msg) {
        if (isShow) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        }
    }

    //自定义时间Toast
    public static void showCustomToast(Context context, String msg, int duration) {
        if (isShow) {
            Toast.makeText(context, msg, duration).show();
        }
    }

    public static void showCustomToast(Context context, int msg, int duration) {
        if (isShow) {
            Toast.makeText(context, msg, duration).show();
        }
    }
}
