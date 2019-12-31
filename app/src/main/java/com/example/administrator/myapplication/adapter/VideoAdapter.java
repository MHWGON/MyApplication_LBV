package com.example.administrator.myapplication.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.net.entity.Video;

import java.util.List;

/**
 * Created by 梁俊廷 on 2019/12/31.
 */

public class VideoAdapter extends BaseQuickAdapter<Video,BaseViewHolder> {
    public VideoAdapter(@LayoutRes int layoutResId, @Nullable List<Video> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Video item) {
        helper.setText(R.id.tv_title,item.getTitle());
        Glide.with(mContext).load(item.getVideoImage()).into((ImageView)helper.getView(R.id.image_view));
    }
}
