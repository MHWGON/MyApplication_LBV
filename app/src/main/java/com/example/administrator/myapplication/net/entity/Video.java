package com.example.administrator.myapplication.net.entity;

/**
 * Created by 梁俊廷 on 2019/12/26.
 */

public class Video {
    private String title;
    private String videoImage;
    private String videoUrl;

    public Video(String title, String videoImage, String videoUrl) {
        this.title = title;
        this.videoImage = videoImage;
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
