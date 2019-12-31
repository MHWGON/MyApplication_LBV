package com.example.administrator.myapplication.net;

import com.example.administrator.myapplication.net.entity.Menu;
import com.example.administrator.myapplication.net.entity.Video;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 梁俊廷 on 2019/12/26.
 */

public class HttpUtil{
    private static HttpUtil mHttpUtil;
    private ApiService mApiService;

    private HttpUtil(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       mApiService=retrofit.create(ApiService.class);
    }
    //单例模式
    public static HttpUtil getInstance(){
        if (mHttpUtil==null){
            mHttpUtil=new HttpUtil();
        }
        return mHttpUtil;
    }
    public void getMenu(Callback<HttpResult<List<Menu>>> callback){
        Call<HttpResult<List<Menu>>> call=mApiService.getMenu();
        call.enqueue(callback);
    }
    public void getVideo(Callback<HttpResult<List<Video>>> callback){
        Call<HttpResult<List<Video>>> call=mApiService.getVideo();
        call.enqueue(callback);
    }
}
