package com.pomelo.myproject.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by paul on 2017/10/15.
 * Description:
 */

public class HttpUtils {

    public static HttpUtils instance;

    public static HttpUtils getInstance() {
        if (instance == null) {
            synchronized (HttpUtils.class) {
                if (instance == null) {
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 获取okhttpclient
     */
    private OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15, TimeUnit.SECONDS)//连接超时时间
                .writeTimeout(10, TimeUnit.SECONDS)//写操作超时时间
                .readTimeout(10, TimeUnit.SECONDS);//读操作超时时间
        return builder.build();
    }

    /**
     * 获取Retrofit
     */
    private Retrofit getRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(getOkHttpClient())
                .baseUrl(URL.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Retrofit build = builder.build();
        return builder.build();
    }

    /**
     * 获取PomeloApi
     */
    public PomeloApi getPomeloApi() {
        return getRetrofit().create(PomeloApi.class);
    }
}
