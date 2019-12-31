package com.example.administrator.myapplication.net;

import android.provider.MediaStore;

import com.example.administrator.myapplication.net.entity.Menu;
import com.example.administrator.myapplication.net.entity.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by 梁俊廷 on 2019/12/26.
 */

public interface ApiService {
    @GET("getnews.php")
    Call<HttpResult<List<Menu>>> getMenu();

    @GET("getvideo.php")
    Call<HttpResult<List<Video>>> getVideo();
}
