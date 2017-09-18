package com.pomelo.myproject.app;

import android.app.Application;

/**
 * Created by paul on 2017/9/18.
 */

public class PomeloApplication extends Application {
    private static PomeloApplication pomeloApplication;

    private static PomeloApplication getMyApplication() {
        return pomeloApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        pomeloApplication = this;
    }
}
