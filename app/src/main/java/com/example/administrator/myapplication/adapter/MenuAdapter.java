package com.example.administrator.myapplication.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.net.entity.Menu;

import java.util.List;

/**
 * Created by 梁俊廷 on 2019/12/26.
 */

public class MenuAdapter extends BaseQuickAdapter<Menu,BaseViewHolder> {
    public MenuAdapter(@LayoutRes int layoutResId, @Nullable List<Menu> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Menu item) {
    helper.setText(R.id.title,item.getTitle());
    helper.setText(R.id.price,item.getPrice());
    Glide.with(mContext).load(item.getImageUrl()).into((ImageView)helper.getView(R.id.thumb));
    }
}
