package com.pomelo.myproject.http;

import android.util.Log;

import com.pomelo.myproject.app.PomeloApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by paul on 2017/10/15.
 * Description:
 */

public class HttpManager {

    private static final String CACHE_NAME = "a_cache";
    public static HttpService httpService;

    public static HttpService getHttpService() {
        return httpService == null ? createHttpService() : httpService;
    }

    public static HttpService createHttpService() {
        //打印请求数据/响应数据
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("cardata", "-------" + message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //缓存存储位置:SDcard/Android/data/包名/dianyin
        String path = PomeloApplication.getMyApplication().getExternalCacheDir().getPath();
        //设置缓存目录
        File cacheFile = new File(path, CACHE_NAME);
        if (!cacheFile.exists()) {
            cacheFile.mkdirs();
        }
        //生成缓存，50M
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
        okBuilder.connectTimeout(15, TimeUnit.SECONDS)//连接超时时间
                .writeTimeout(10, TimeUnit.SECONDS)//写操作超时时间
                .readTimeout(10, TimeUnit.SECONDS);//读操作超时时间
        OkHttpClient okHttpClient = okBuilder.build();

        Retrofit.Builder rBuilder = new Retrofit.Builder();
        rBuilder.baseUrl(HttpUrl.BaseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Retrofit retrofit = rBuilder.build();
        return retrofit.create(HttpService.class);
    }
    /**
     * 添加公共头信息
     */
    private static Interceptor addCommonHeader() {
        Interceptor commonHeaderInterceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                builder.addHeader("token", "3b6a72fba990f3a0db1dfcf033498c89a97a2b3b");
                return chain.proceed(builder.build());
            }
        };
        return commonHeaderInterceptor;
    }


    /**
     * 添加缓存拦截
     */
    private static Interceptor addCacheInterceptor() {
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //网络不可用
                if (!NetworkUtil.isNetworkAvailable(PomeloApplication.getMyApplication())) {
                    //在请求头中加入：强制使用缓存，不访问网络
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }


                okhttp3.Response response = chain.proceed(request);
                //网络可用
                if (NetworkUtil.isNetworkAvailable(PomeloApplication.getMyApplication())) {
                    String cacheControl = request.cacheControl().toString();
                    response.newBuilder()
                            .header("Cache-Control", cacheControl)
                            .build();
                } else {
                    // 无网络时
                    response.newBuilder()
                            .header("Cache-Control", CacheControl.FORCE_CACHE.toString())
                            .build();
                }
                return response;
            }
        };
        return cacheInterceptor;
    }
}
