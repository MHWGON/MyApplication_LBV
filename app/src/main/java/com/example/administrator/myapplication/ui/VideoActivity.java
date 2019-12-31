package com.example.administrator.myapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.administrator.myapplication.R;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoActivity extends AppCompatActivity {
private JZVideoPlayerStandard mJzVideoPlayerStandard;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        mJzVideoPlayerStandard=(JZVideoPlayerStandard)findViewById(R.id.jz_video_player);

        Intent intent=getIntent();
        String title=intent.getStringExtra("title");
        String imageUrl=intent.getStringExtra("imageUrl");
        String videoUrl=intent.getStringExtra("videoUrl");

        mJzVideoPlayerStandard.setUp(videoUrl,JZVideoPlayer.SCREEN_WINDOW_NORMAL,title);

        Glide.with(this).load(imageUrl).into(mJzVideoPlayerStandard.thumbImageView);
    }
}
