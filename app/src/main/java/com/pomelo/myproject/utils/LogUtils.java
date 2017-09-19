package com.pomelo.myproject.utils;

import android.util.Log;

/**
 * Created by lxw on 2017/2/14.
 * Log统一管理类
 */

public class LogUtils {

    private LogUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    //是否需要打印bug，可以在application的onCreate函数里面初始化
    public static boolean isDebug = true;

    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.d(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.v(tag, msg);
    }
}
