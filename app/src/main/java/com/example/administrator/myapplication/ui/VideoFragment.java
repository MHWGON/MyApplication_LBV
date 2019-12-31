package com.example.administrator.myapplication.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.VideoAdapter;
import com.example.administrator.myapplication.loader.BannerImageLoader;
import com.example.administrator.myapplication.net.HttpResult;
import com.example.administrator.myapplication.net.HttpUtil;
import com.example.administrator.myapplication.net.entity.Video;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {
private View mView;
private RecyclerView mRecyclerView;
private List<Video>  mVideos;
private VideoAdapter mVideoAdapter;
private Banner mBanner;
private List<String> mBannerImages;
    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_video, container, false);
        initView();
        init();
        return mView;
    }

    private void initView() {
       mRecyclerView=(RecyclerView)mView.findViewById(R.id.recycler_view_video);
       mBanner=(Banner)mView.findViewById(R.id.banner);
    }
    private void init(){

    mBannerImages=new ArrayList<>();
        mBannerImages.add("http:/10.0.2.2/news/picture/picture1.jpg");
        mBannerImages.add("http:/10.0.2.2/news/picture/picture2.jpg");
        mBannerImages.add("http:/10.0.2.2/news/picture/picture3.jpg");
        mBannerImages.add("http:/10.0.2.2/news/picture/picture4.jpg");

        mBanner.setImageLoader(new BannerImageLoader());
        mBanner.setImages(mBannerImages);
        mBanner.start();

        mVideos=new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mVideoAdapter=new VideoAdapter(R.layout.item_view_video,mVideos);
        mRecyclerView.setAdapter(mVideoAdapter);
        HttpUtil.getInstance().getVideo(new Callback<HttpResult<List<Video>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<Video>>> call, Response<HttpResult<List<Video>>> response) {
                HttpResult<List<Video>> res=response.body();
                List<Video> data=res.getData();
                mVideoAdapter.addData(data);
            }

            @Override
            public void onFailure(Call<HttpResult<List<Video>>> call, Throwable t) {

            }
        });
        mVideoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                Intent intent=new Intent(getActivity(), VideoActivity.class);
                intent.putExtra("title",mVideos.get(position).getTitle());
                intent.putExtra("imageUrl",mVideos.get(position).getVideoImage());
                intent.putExtra("videoUrl",mVideos.get(position).getVideoUrl());
                startActivity(intent);
            }
        });

    }

}
