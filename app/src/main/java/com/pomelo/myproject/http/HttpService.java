package com.pomelo.myproject.http;


import com.pomelo.myproject.bean.GankIoDataBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by paul on 2017/10/15.
 * Description:
 */

public interface HttpService {

    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * 请求个数： 数字，大于0
     * 第几页：数字，大于0
     * eg: http://gank.io/api/data/Android/10/1
     */
    @GET("data/{type}/{pre_page}/{page}")
    Call<GankIoDataBean> getGankIoData(@Path("type") String type, @Path("pre_page") int pre_page, @Path("page") int page);
}
